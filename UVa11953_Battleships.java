package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3104 (11953 - Battleships) */
/* SUBMISSION: 09236413 */
/* SUBMISSION TIME: 2011-09-07 21:41:43 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11953_Battleships {
	
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	static void dfs(int r, int c) {
		if (!inside(r, c))
			return;
		if (visited[r][c] || grid[r][c] == '.')
			return;
		
		visited[r][c] = true;
		
		for (int d = 0; d < 4; ++d)
			dfs(r + dr[d], c + dc[d]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(in.readLine());
			grid = new char[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; ++i)
				grid[i] = in.readLine().toCharArray();
			
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (!visited[i][j] && grid[i][j] == 'x') {
						++cnt;
						dfs(i, j);
					}
			System.out.println("Case " + t + ": " + cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
