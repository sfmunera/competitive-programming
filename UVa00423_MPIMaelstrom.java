package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 364 (423 - MPI Maelstrom) */
/* SUBMISSION: 10371959 */
/* SUBMISSION TIME: 2012-07-22 16:00:51 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00423_MPIMaelstrom {
	
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			int[][] adj = new int[N][N];
			
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j) {
					if (i == j)
						adj[i][j] = 0;
					else
						adj[i][j] = INF;
				}
			for (int i = 1; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				for (int j = 0; j < parts.length; ++j)
					if (!parts[j].equals("x")) {
						int w = Integer.parseInt(parts[j]);
						adj[i][j] = adj[j][i] = w;
					}
			}
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
			int ans = 0;
			for (int i = 0; i < N; ++i)
				ans = Math.max(ans, adj[0][i]);
			System.out.println(ans);
			
			//for (int i = 0;i < N; ++i)
			//	System.out.println(Arrays.toString(adj[i]));
		}
		
		in.close();
		System.exit(0);
	}
}
