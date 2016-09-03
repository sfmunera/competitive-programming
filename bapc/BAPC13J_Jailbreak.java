package bapc;

import java.util.*;

public class BAPC13J_Jailbreak {
	
	static final int INF = (int) 1e9;
	static final int BIG = 100 * 100 + 7;
	static final int SMALL = 1;
	
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, -1, 1, 0};
	
	static class Pair {
		int x, y;
		Pair(int x, int y) { this.x = x; this.y = y; }
	}
	
	static class Result {
		int[][] dist;
		Pair[][] parent;
		Result(int[][] dist, Pair[][] parent) {
			this.dist = dist;
			this.parent = parent;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		int dist;
		Pair pos;
		public QueueItem(Pair pos, int dist) {
			this.pos = pos; this.dist = dist;
		}
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}

	static Result dijkstra(Pair s, char[][] map) {
		int[][] dist = new int[rows][cols];
		Pair[][] p = new Pair[rows][cols];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();

		for (int i = 0; i < rows; ++i) Arrays.fill(dist[i], INF);
		dist[s.x][s.y] = 0;
		Q.offer(new QueueItem(s, 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int r = q.pos.x, c = q.pos.y, d = q.dist;
			if (d == dist[r][c]) {
				for (int i = 0; i < 4; ++i) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
					if (map[nr][nc] == '*') continue;
					int w = map[r][c] == '#' ? BIG : SMALL;
					if (dist[r][c] + w < dist[nr][nc]) {
						dist[nr][nc] = dist[r][c] + w;
						p[nr][nc] = q.pos;
						Q.offer(new QueueItem(new Pair(nr, nc), dist[nr][nc]));
					}
				}
			}
		}
		return new Result(dist, p);
	}

	static char[][] copy(char[][] map) {
		char[][] tmp = new char[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	
	static int go(Pair prisoner1, Pair prisoner2, char[][] map) {		
		Result result1 = dijkstra(prisoner1, map);
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < rows; ++i) {
			if (map[i][0] != '*' && result1.dist[i][0] < INF) {
				ans = Math.min(ans, go2(prisoner1, prisoner2, copy(map), result1.parent, new Pair(i, 0)));
			}
			if (map[i][cols - 1] != '*' && result1.dist[i][cols - 1] < INF) {
				ans = Math.min(ans, go2(prisoner1, prisoner2, copy(map), result1.parent, new Pair(i, cols - 1)));
			}
		}
		
		for (int j = 0; j < cols; ++j) {
			if (map[0][j] != '*' && result1.dist[0][j] < INF) {
				ans = Math.min(ans, go2(prisoner1, prisoner2, copy(map), result1.parent, new Pair(0, j)));
			}
			if (map[rows - 1][j] != '*' && result1.dist[rows - 1][j] < INF) {
				ans = Math.min(ans, go2(prisoner1, prisoner2, copy(map), result1.parent, new Pair(rows - 1, j)));
			}
		}
		
		return ans;
	}
	
	static int go2(Pair prisoner1, Pair prisoner2, char[][] map, Pair[][] parent, Pair outdoor) {		
		int ans = 0;
		Pair cur = outdoor;
		while (cur != null) {
			if (map[cur.x][cur.y] == '#') {
				++ans;
				map[cur.x][cur.y] = '.';
			}
			cur = parent[cur.x][cur.y];
		}
		
		Result result2 = dijkstra(prisoner2, map);
		cur = prisoner1;
		while (cur != null) {
			if (map[cur.x][cur.y] == '#') {
				++ans;
				map[cur.x][cur.y] = '.';
			}
			cur = result2.parent[cur.x][cur.y];
		}
		
		return ans;
	}
	
	static int rows, cols;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			rows = in.nextInt();
			cols = in.nextInt();
			
			char[][] map = new char[rows][cols];
			for (int i = 0; i < rows; ++i) {
				map[i] = in.next().toCharArray();
			}
			
			Pair[] prisoners = new Pair[2];
			int numPrisoners = 0;
			
			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < cols; ++j) {
					if (map[i][j] == '$') {
						prisoners[numPrisoners++] = new Pair(i, j);
					}
				}
			}
			
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < numPrisoners; ++i) {
				ans = Math.min(ans, go(prisoners[i], prisoners[1 - i], copy(map)));
			}
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
