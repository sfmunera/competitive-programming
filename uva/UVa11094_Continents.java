package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2035 (11094 - Continents) */
/* SUBMISSION: 09121439 */
/* SUBMISSION TIME: 2011-08-06 19:26:27 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11094_Continents {
	
	static int M, N;
	static char[][] map;
	static boolean[][] visited;
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < M && c < N;
	}
	
	static int dfs(int r, int c, char mark) {
		if (!inside(r, c))
			return 0;
		if (visited[r][c] || map[r][c] != mark)
			return 0;
		
		visited[r][c] = true;
		
		return 1 + dfs(r + 1, c, mark) + dfs(r - 1, c, mark) + 
			dfs(r, c == N - 1 ? 0 : c + 1, mark) + dfs(r, c == 0 ? N - 1 : c - 1, mark);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			M = Integer.parseInt(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			
			map = new char[M][N];
			visited = new boolean[M][N];
			
			for (int i = 0; i < M; ++i)
				map[i] = in.readLine().toCharArray();
			
			line = in.readLine();
			stk = new StringTokenizer(line);
			int sr = Integer.parseInt(stk.nextToken());
			int sc = Integer.parseInt(stk.nextToken());
			
			in.readLine();
			char c = map[sr][sc];
			dfs(sr, sc, c);
			
			int max = 0;
			for (int i = 0; i < M; ++i)
				for (int j = 0; j < N; ++j)
					if (!visited[i][j] && map[i][j] == c)
						max = Math.max(max, dfs(i, j, map[i][j]));
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}