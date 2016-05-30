package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2597 (11561 - Getting Gold) */
/* SUBMISSION: 09235090 */
/* SUBMISSION TIME: 2011-09-07 15:07:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11561_GettingGold {
	
	static int W, H;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}
	
	static int dfs(int r, int c) {
		if (!inside(r, c))
			return 0;
		if (visited[r][c] || map[r][c] == 'T' || map[r][c] == '#')
			return 0;
		
		visited[r][c] = true;
		
		int cnt = map[r][c] == 'G' ? 1 : 0;
		
		int T = 0;
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (inside(nr, nc) && map[nr][nc] == 'T')
				++T;
		}
		if (T > 0) {
			for (int d = 0; d < 4; ++d) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (inside(nr, nc) && map[nr][nc] == 'T')
					visited[nr][nc] = true;
			}
			return cnt;
		}
		
		
		for (int d = 0; d < 4; ++d)
			cnt += dfs(r + dr[d], c + dc[d]);
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());
			
			map = new char[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < H; ++i)
				map[i] = in.readLine().toCharArray();
			
			int sr = -1;
			int sc = -1;
			boolean found = false;
			for (int i = 0; i < H && !found; ++i)
				for (int j = 0; j < W && !found; ++j)
					if (map[i][j] == 'P') {
						sr = i;
						sc = j;
						found = true;
					}
			
			System.out.println(dfs(sr, sc));
		}
		
		in.close();
		System.exit(0);
	}
}