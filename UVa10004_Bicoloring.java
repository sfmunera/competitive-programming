package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 945 (10004 - Bicoloring) */
/* SUBMISSION: 09422024 */
/* SUBMISSION TIME: 2011-10-29 23:17:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10004_Bicoloring {
	
	static int N;
	static boolean[][] adj;
	
	static boolean bfs(int s) {
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		int[] state = new int[N];
		
		Arrays.fill(state, -1);
		
		visited[s] = true;
		state[s] = 0;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int i = 0; i < N; ++i)
				if (adj[v][i]) {
					
					
					if (state[i] == -1)
						state[i] = state[v] == 0 ? 1 : 0;
					else if (state[i] == state[v])
						return false;
					if (!visited[i]) {
						visited[i] = true;
						Q.offer(i);
					}
				}
			//System.out.println(Arrays.toString(state));
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			int M = Integer.parseInt(in.readLine());
			
			adj = new boolean[N][N];
			
			for (int i = 0; i < M; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int from = Integer.parseInt(parts[0]);
				int to = Integer.parseInt(parts[1]);
				adj[from][to] = adj[to][from] = true;
			}
			
			System.out.println(bfs(0) ? "BICOLORABLE." : "NOT BICOLORABLE.");
		}
		
		in.close();
		System.exit(0);
	}
}