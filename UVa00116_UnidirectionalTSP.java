package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 52 (116 - Unidirectional TSP) */
/* SUBMISSION: 11416810 */
/* SUBMISSION TIME: 2013-03-10 18:50:44 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00116_UnidirectionalTSP {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int R = in.nextInt();
			int C = in.nextInt();
			
			int[][] mat = new int[R][C];
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					mat[i][j] = in.nextInt();
			
			long[][] dp = new long[R][C];
			int[][] pr = new int[R][C];
			for (int i = 0; i < R; ++i) {
				Arrays.fill(pr[i], -1);
				Arrays.fill(dp[i], Long.MAX_VALUE);
				dp[i][C - 1] = mat[i][C - 1];
			}
			
			int[] di = {-1, 0, 1};
			for (int j = C - 1; j > 0; --j)
				for (int i = 0; i < R; ++i)
					for (int k = 0; k < 3; ++k) {
						int ni = (i + di[k] + R) % R;
						if (dp[ni][j - 1] > dp[i][j] + mat[ni][j - 1]) {
							dp[ni][j - 1] = dp[i][j] + mat[ni][j - 1];
							pr[ni][j - 1] = i;
						}
					}
			long ans = Long.MAX_VALUE;
			int r = 0;
			for (int i = 0; i < R; ++i) {
				if (dp[i][0] < ans) {
					ans = dp[i][0];
					r = i;
				}
			}
			
			System.out.print(r + 1);
			for (int i = 0; i < C - 1; ++i) {
				System.out.print(" " + (pr[r][i] + 1));
				r = pr[r][i];
			}
			System.out.println();
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
