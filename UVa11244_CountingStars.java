package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2201 (11244 - Counting Stars) */
/* SUBMISSION: 09234899 */
/* SUBMISSION TIME: 2011-09-07 14:01:50 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11244_CountingStars {
	
	static int R, C;
	static char[][] sky;
	static boolean[][] visited;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static int dfs(int r, int c) {
		if (!inside(r, c))
			return 0;
		if (visited[r][c] || sky[r][c] == '.')
			return 0;
		
		visited[r][c] = true;
		int cnt = 1;
		
		for (int d = 0; d < 8; ++d)
			cnt += dfs(r + dr[d], c + dc[d]);
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			
			if (R == 0 && C == 0)
				break;
			
			sky = new char[R][C];
			visited = new boolean[R][C];
			
			for (int i = 0; i < R; ++i)
				sky[i] = in.readLine().toCharArray();
			
			int res = 0;
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					if (!visited[i][j])
						if (dfs(i, j) == 1)
							++res;
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}