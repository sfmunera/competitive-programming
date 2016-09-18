package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2458 (11463 - Commandos) */
/* SUBMISSION: 10892285 */
/* SUBMISSION TIME: 2012-11-16 03:40:46 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11463_Commandos {
	
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			int[][] adj = new int[N][N];
			
			for (int i = 0; i < N; ++i) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}
			
			int R = Integer.parseInt(in.readLine());
			for (int i = 0; i < R; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]);
				int v = Integer.parseInt(parts[1]);
				
				adj[u][v] = adj[v][u] = 1;
			}
			
			String[] parts = in.readLine().split("[ ]+");
			int s = Integer.parseInt(parts[0]);
			int e = Integer.parseInt(parts[1]);
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
			
			int ans = 0;
			for (int i = 0; i < N; ++i)
				ans = Math.max(ans, adj[s][i] + adj[i][e]);
			System.out.println("Case " + t + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
