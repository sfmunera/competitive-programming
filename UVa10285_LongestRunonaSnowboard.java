package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1226 (10285 - Longest Run on a Snowboard) */
/* SUBMISSION: 09036449 */
/* SUBMISSION TIME: 2011-07-10 16:07:32 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10285_LongestRunonaSnowboard {
	
	static int R, C, res;
	static int[][] heights;
	static boolean[][] visited;
	
	static boolean valid(int r, int c, int h) {
		return r >= 0 && c >= 0 && r < R && c < C && heights[r][c] < h && !visited[r][c];
	}
	
	static void solve(int r, int c, int h, int sol) {
		if (!valid(r, c, h)) {
			res = Math.max(res, sol);
			return;
		}
		visited[r][c] = true;
		solve(r - 1, c, heights[r][c], sol + 1);
		solve(r + 1, c, heights[r][c], sol + 1);
		solve(r, c - 1, heights[r][c], sol + 1);
		solve(r, c + 1, heights[r][c], sol + 1);
		
		visited[r][c] = false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			String name = in.next();
			R = in.nextInt();
			C = in.nextInt();
			heights = new int[R][C];
			visited = new boolean[R][C];
			
			for (int r = 0; r < R; ++r)
				for (int c = 0; c < C; ++c)
					heights[r][c] = in.nextInt();
			
			res = 0;
			
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					solve(i, j, 101, 0);
			
			System.out.println(name + ": " + res);
		}
	}
}