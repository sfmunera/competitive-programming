package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1911 (10970 - Big Chocolate) */
/* SUBMISSION: 10534430 */
/* SUBMISSION TIME: 2012-08-28 16:04:51 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10970_BigChocolate {
	
	static int[][] memo;
	
	static int solve(int M, int N) {
		if (memo[M][N] != -1)
			return memo[M][N];
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= M / 2; ++i)
			ans = Math.min(ans, solve(i, N) + solve(M - i, N));
		
		for (int j = 1; j <= N / 2; ++j)
			ans = Math.min(ans, solve(M, j) + solve(M, N - j));
		
		return memo[M][N] = 1 + ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		memo = new int[305][305];
		for (int i = 0; i < 305; ++i)
			for (int j = 0; j < 305; ++j)
				memo[i][j] = -1;
		for (int i = 1; i < 305; ++i)
			memo[i][1] = memo[1][i] = i - 1;
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int M = Integer.parseInt(parts[0]);
			int N = Integer.parseInt(parts[1]);
			
			System.out.println(solve(M, N));
		}
		
		in.close();
		System.exit(0);
	}
}
