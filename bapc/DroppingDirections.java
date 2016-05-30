import java.util.*;
import java.io.*;

public class DroppingDirections {
	
	static class State {
		int node, dir;
		State(int node, int dir) {
			this.node = node;
			this.dir = dir;
		}
	}
	
	static boolean bfs(int[][] adj, boolean[][] seen, int s, int dir, int g) {
		Queue<State> Q = new LinkedList<State>();
		
		seen[s][dir % 2] = true;
		Q.offer(new State(s, dir));
		boolean containsGoal = false;
		
		while (!Q.isEmpty()) {
			State state = Q.poll();
			if (state.node == g) {
				containsGoal = true;
			}
			int next = adj[state.node][state.dir];
			
			//System.out.println(state.node + " " + next);
			int newdir = 0;
			for (int k = 0; k < 4; ++k) {
				if (adj[next][k] == state.node) {
					newdir = (k + 2) % 4;
				}
			}
			if (!seen[next][newdir % 2]) {
				seen[next][newdir % 2] = true;
				Q.offer(new State(next, newdir));
			}
		}
		return containsGoal;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int g = in.nextInt() - 1;
			
			int[][] adj = new int[n][4];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < 4; ++j) {
					adj[i][j] = in.nextInt() - 1;
				}
				//System.out.println(i + ": " + Arrays.toString(adj[i]));
			}
			
			boolean[][] seen = new boolean[n][2];
			
			int ans = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < 2; ++j) {
					if (!seen[i][j]) {
						if (!bfs(adj, seen, i, j, g)) {
							//System.out.println("New: " + i + " " + j);
							++ans;
						}
					}
				}
			}
			
			System.out.println(ans);
		}
		
		in.close();
	}
}
