package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3108 (11957 - Checkers) */
/* SUBMISSION: 11388546 */
/* SUBMISSION TIME: 2013-03-05 22:35:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11957_Checkers {
	
	static final int MOD = 1000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			char[][] board = new char[N][N];
			int[][] dp = new int[N][N];
			
			for (int i = 0; i < N; ++i)
				board[i] = in.readLine().toCharArray();
			
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (board[i][j] == 'W') {
						dp[i][j] = 1;
						break;
					}
			
			int[] di = {-1, -1};
			int[] dj = {-1, 1};
			for (int i = N - 1; i > 0; --i)
				for (int j = 0; j < N; ++j)
					for (int k = 0; k < 2; ++k) {
						int ni = i + di[k];
						int nj = j + dj[k];
						
						if (ni >= 0 && ni < N && nj >= 0 && nj < N)
							if (board[ni][nj] == '.')
								dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % MOD;
							else {
								ni = i + 2 * di[k];
								nj = j + 2 * dj[k];
								if (ni >= 0 && ni < N && nj >= 0 && nj < N)
									if (board[ni][nj] == '.')
										dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % MOD;
							}
					}
			
			int ans = 0;
			for (int j = 0; j < N; ++j)
				ans = (ans + dp[0][j]) % MOD;
			System.out.println("Case " + t + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
