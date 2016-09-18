package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1537 (10596 - Morning Walk) */
/* SUBMISSION: 10591885 */
/* SUBMISSION TIME: 2012-09-11 21:32:14 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10596_MorningWalk {
	
	static int N;
	static boolean[][] adj;
	static boolean[] visited;
		
	static void dfs(int s) {
		visited[s] = true;
		
		for (int i = 0; i < N; ++i)
			if (!visited[i] && adj[s][i])
				dfs(i);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int R = Integer.parseInt(parts[1]);
			
			adj = new boolean[N][N];
			
			int[] degree = new int[N];
			for (int i = 0; i < R; ++i) {
				parts = in.readLine().split("[ ]+");
				int c1 = Integer.parseInt(parts[0]);
				int c2 = Integer.parseInt(parts[1]);
				++degree[c1];
				++degree[c2];
				adj[c1][c2] = adj[c2][c1] = true;
			}
			
			boolean ok = true;
			for (int i = 0; i < N; ++i)
				if (degree[i] % 2 != 0) {
					ok = false;
					break;
				}
			visited = new boolean[N];
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				if (!visited[i]) {
					++cnt;
					dfs(i);
				}			
			System.out.println((ok && cnt == 1 ? "" : "Not ") + "Possible");
		}
		
		in.close();
		System.exit(0);
	}
}
