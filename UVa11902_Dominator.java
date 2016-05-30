package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3053 (11902 - Dominator) */
/* SUBMISSION: 10932500 */
/* SUBMISSION TIME: 2012-11-24 14:20:44 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11902_Dominator {
	
	static int N;
	static boolean[][] adj, domination;
	static boolean[] visited;
	
	static void dfs(int s, int ignore) {
		if (s == ignore) return;
		visited[s] = true;

		for (int i = 0; i < N; ++i)
			if (adj[s][i] && !visited[i])
				dfs(i, ignore);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(in.readLine());
			adj = new boolean[N][N];
			domination = new boolean[N][N];
			
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				for (int j = 0; j < N; ++j) {
					int val = Integer.parseInt(parts[j]);
					if (val == 1)
						adj[i][j] = true;
				}
			}
			visited = new boolean[N];
			dfs(0, -1);
			boolean[] reachable = visited.clone();
			
			for (int i = 0; i < N; ++i) {
				visited = new boolean[N];
				dfs(0, i);
				for (int j = 0; j < N; ++j)
					if (reachable[j] && !visited[j])
						domination[i][j] = true;
			}
			System.out.println("Case " + t + ":");
			
			String sep = "";
			for (int i = 0; i < 2 * N + 1; ++i)
				if (i == 0 || i == 2 * N)
					sep += "+";
				else
					sep += "-";
			System.out.println(sep);
			for (int i = 0; i < N; ++i) {
				System.out.print("|");
				for (int j = 0; j < N; ++j)
					System.out.print((domination[i][j] ? "Y" : "N") + "|");
				System.out.println();
				System.out.println(sep);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
