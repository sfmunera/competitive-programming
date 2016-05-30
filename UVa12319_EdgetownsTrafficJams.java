package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3741 (12319 - Edgetown's Traffic Jams) */
/* SUBMISSION: 09351435 */
/* SUBMISSION TIME: 2011-10-09 14:09:05 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12319_EdgetownsTrafficJams {
	
	static int[] bfs(boolean[][] adj, int n, int s) {
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];
		
		Arrays.fill(distance, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.offer(s);
		visited[s] = true;
		distance[s] = 0;
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int w = 0; w < n; ++w) {
				if (adj[v][w] && !visited[w]) {
					visited[w] = true;
					distance[w] = distance[v] + 1;
					Q.offer(w);
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("edgetown.in"));
		StringTokenizer stk;
		
		while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if (n == 0)
				break;
			
			boolean[][] adj1 = new boolean[n][n];
			for (int i = 0; i < n; ++i) {
				stk = new StringTokenizer(in.readLine().trim());
				stk.nextToken();
				while (stk.hasMoreTokens()) {
					int j = Integer.parseInt(stk.nextToken());
					adj1[i][j - 1] = true;
				}
			}

			int[][] dist1 = new int[n][n];
			for (int i = 0; i < n; ++i)
				dist1[i] = bfs(adj1, n, i);

			//for (int i = 0; i < n; ++i)
			//	System.out.println(Arrays.toString(dist1[i]));
			
			boolean[][] adj2 = new boolean[n][n];
			for (int i = 0; i < n; ++i) {
				stk = new StringTokenizer(in.readLine().trim());
				stk.nextToken();
				while (stk.hasMoreTokens()) {
					int j = Integer.parseInt(stk.nextToken());
					adj2[i][j - 1] = true;
				}
			}
			
			int[][] dist2 = new int[n][n];
			for (int i = 0; i < n; ++i)
				dist2[i] = bfs(adj2, n, i);

			//for (int i = 0; i < n; ++i)
			//	System.out.println(Arrays.toString(dist2[i]));
			
			stk = new StringTokenizer(in.readLine().trim());
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			
			boolean ok = true;
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < n; ++j) {
					int x = dist1[i][j];
					if (A * x + B < dist2[i][j])
						ok = false;
				}
			System.out.println(ok ? "Yes" : "No");
		}
		
		in.close();
		System.exit(0);
	}
}