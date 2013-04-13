package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1867 (10926 - How Many Dependencies?) */
/* SUBMISSION: 10595995 */
/* SUBMISSION TIME: 2012-09-12 23:23:56 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10926_HowManyDependencies {
	
	static int N;
	static boolean[][] adj;
	static boolean[] visited;	
	
	static int dfs(int s) {
		visited[s] = true;
		int cnt = 0;
		for (int i = 0; i < N; ++i)
			if (!visited[i] && adj[s][i])
				cnt += dfs(i);
		return 1 + cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			
			if (N == 0) break;
			
			adj = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int T = Integer.parseInt(parts[0]);
				for (int j = 1; j <= T; ++j) {
					int to = Integer.parseInt(parts[j]) - 1;
					adj[i][to] = true;
				}
			}
			
			int max = 0;
			int ans = -1;
			for (int i = 0; i < N; ++i) {
				visited = new boolean[N];
				int cnt = dfs(i);
				if (cnt > max) {
					max = cnt;
					ans = i;
				}
			}
			
			System.out.println(ans + 1);
		}
		
		in.close();
		System.exit(0);
	}
}
