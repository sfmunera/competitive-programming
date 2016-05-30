package facebook;

import java.io.*;
import java.util.*;

public class LaserMaze {
	
	static enum Direction { NORTH, EAST, SOUTH, WEST };
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, -1, 1, 0};
	
	static class Pair {
		int r, c;
		public Pair(int r, int c) {
			this.r = r; this.c = c;
		}
		@Override public boolean equals(Object o) {
			if (!(o instanceof Pair)) {
				return false;
			}
			Pair p = (Pair) o;
			return this.r == p.r && this.c == p.c;
		}
		@Override public int hashCode() {
			return 31 + 100 * (r + 1) + c;
		}
		@Override public String toString() {
			return String.format("%02d", r) + String.format("%02d", c);
		}
	}
	
	static class Laser {
		Direction dir;
		Pair pos;
		public Laser(Direction dir, Pair pos) {
			this.dir = dir;
			this.pos = pos;
		}
		public boolean attacks(Pair goal, char[][] maze) {
			if (dir == Direction.NORTH) {
				if (goal.c != pos.c || goal.r >= pos.r) {
					return false;
				}
				for (int i = goal.r + 1; i < pos.r; ++i) {
					if (maze[i][pos.c] != '.') {
						return false;
					}
				}
			} else if (dir == Direction.EAST) {
				if (goal.r != pos.r || goal.c <= pos.c) {
					return false;
				}
				for (int i = pos.c + 1; i < goal.c; ++i) {
					if (maze[pos.r][i] != '.') {
						return false;
					}
				}
			} else if (dir == Direction.SOUTH) {
				if (goal.c != pos.c || goal.r <= pos.r) {
					return false;
				}
				for (int i = pos.r + 1; i < goal.r; ++i) {
					if (maze[i][pos.c] != '.') {
						return false;
					}
				}
			} else if (dir == Direction.WEST) {
				if (goal.r != pos.r || goal.c >= pos.c) {
					return false;
				}
				for (int i = goal.c + 1; i < pos.c; ++i) {
					if (maze[pos.r][i] != '.') {
						return false;
					}
				}
			}
			
			return true;
		}
		public void updateDirection() {
			if (dir == Direction.NORTH) {
				dir = Direction.EAST;
			} else if (dir == Direction.EAST) {
				dir = Direction.SOUTH;
			} else if (dir == Direction.SOUTH) {
				dir = Direction.WEST;
			} else if (dir == Direction.WEST) {
				dir = Direction.NORTH;
			}
		}
		@Override public String toString() {
			if (dir == Direction.NORTH) {
				return "1";
			} else if (dir == Direction.EAST) {
				return "2";
			} else if (dir == Direction.SOUTH) {
				return "3";
			} else if (dir == Direction.WEST) {
				return "4";
			}
			return "";
		}
	}
	
	static class State {
		Pair pos;
		List<Laser> lasers;
		
		public State(Pair pos, List<Laser> lasers) {
			this.pos = pos;
			this.lasers = new ArrayList<Laser>();
			for (Laser l : lasers) {
				this.lasers.add(new Laser(l.dir, l.pos));
			}
		}
		
		public void updateLasers() {
			for (Laser l : lasers) {
				l.updateDirection();
			}
		}
		
		public boolean valid(char[][] maze) {
			for (Laser l : lasers) {
				if (l.attacks(pos, maze)) {
					return false;
				}
			}
			return true;
		}
		
		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Laser l : lasers) {
				sb.append(l);
			}
			sb.append(pos);
			
			return sb.toString();
		}
		
		@Override public boolean equals(Object o) {
			if (!(o instanceof State)) {
				return false;
			}
			State s = (State) o;
			return this.toString().equals(s.toString());
		}
		
		@Override public int hashCode() {
			return this.toString().hashCode();
		}
	}
	
	static int bfs(State initialState, char[][] maze, Pair goal, int R, int C) {
		Queue<State> Q = new LinkedList<State>();
		Map<State, Integer> dist = new HashMap<State, Integer>();
		
		Q.add(initialState);
		dist.put(initialState, 0);
		
		while (!Q.isEmpty()) {
			State s = Q.poll();
			
			if (s.pos.equals(goal)) {
				return dist.get(s);
			}
			
			int r = s.pos.r;
			int c = s.pos.c;
			int D = dist.get(s);
			
			for (int d = 0; d < 4; ++d) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && maze[nr][nc] == '.') {
					State next = new State(new Pair(nr, nc), s.lasers);
					next.updateLasers();
					if (next.valid(maze) && !dist.containsKey(next)) {
						Q.offer(next);
						dist.put(next, D + 1);
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("C.in")));
		System.setOut(new PrintStream(new File("C.out")));
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int R = in.nextInt();
			int C = in.nextInt();
			
			char[][] maze = new char[R][C];
			Pair s = new Pair(0, 0);
			Pair g = new Pair(0, 0);
			List<Laser> lasers = new ArrayList<Laser>();
			for (int i = 0; i < R; ++i) {
				char[] line = in.next().toCharArray();
				for (int j = 0; j < C; ++j) {
					if (line[j] == 'S') {
						maze[i][j] = '.';
						s = new Pair(i, j);
					} else if (line[j] == 'G') {
						maze[i][j] = '.';
						g = new Pair(i, j);
					} else if (line[j] == '.' || line[j] == '#') {
						maze[i][j] = line[j];
					} else {
						Direction dir = Direction.NORTH;
						Pair pos = new Pair(i, j);
						if (line[j] == '<') {
							dir = Direction.WEST;
						} else if (line[j] == '>') {
							dir = Direction.EAST;
						} else if (line[j] == '^') {
							dir = Direction.NORTH;
						} else if (line[j] == 'v') {
							dir = Direction.SOUTH;
						}
						
						lasers.add(new Laser(dir, pos));
					}
				}
			}
			
			State initialState = new State(s, lasers);
			
			int ans = bfs(initialState, maze, g, R, C);
			
			System.out.println("Case #" + t + ": " + (ans == -1 ? "impossible" : ans));
		}
		
		in.close();
	}
}
