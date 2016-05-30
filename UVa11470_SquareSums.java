package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2465 (11470 - Square Sums) */
/* SUBMISSION: 09234997 */
/* SUBMISSION TIME: 2011-09-07 14:30:02 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11470_SquareSums {
	
	static int n;
	static int[][] square;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}
	
	static int dfs(int r, int c, int ini, int end, int sum) {
		if (!inside(r, c))
			return 0;
		if (visited[r][c] || (r != ini && r != end && c != ini && c != end))
			return 0;
		
		visited[r][c] = true;
		
		for (int d = 0; d < 4; ++d)
			sum += dfs(r + dr[d], c + dc[d], ini, end, sum);
		return sum + square[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			n = Integer.parseInt(in.readLine());
			
			if (n == 0)
				break;
			
			square = new int[n][n];
			visited = new boolean[n][n];
			
			for (int i = 0; i < n; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; ++j)
					square[i][j] = Integer.parseInt(stk.nextToken());
			}
			int m = (int)Math.ceil(n / 2.0);
			int[] res = new int[m];
			for (int i = 0; i < m; ++i) {
				res[i] = dfs(i, i, i, n - i - 1, 0);
			}
			System.out.print("Case " + t + ":");
			for (int i = 0; i < m; ++i)
				System.out.print(" " + res[i]);
			System.out.println();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
