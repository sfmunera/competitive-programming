package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 977 (10036 - Divisibility) */
/* SUBMISSION: 10224785 */
/* SUBMISSION TIME: 2012-06-14 18:55:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10036_Divisibility {
	
	static int N, K;
	static int[] numbers;
	static int[][] memo;
	
	static int solve(int i, int sum) {
		if (i == N && sum != 0)
			return 0;
		if (i == N && sum == 0)
			return 1;
		
		if (memo[i][sum] != -1)
			return memo[i][sum];

		return memo[i][sum] = solve(i + 1, Math.abs(sum + numbers[i]) % K) |
		                      solve(i + 1, Math.abs(sum - numbers[i]) % K);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int MAXN = 10005;
		int MAXM = 105;
		memo = new int[MAXN][MAXM];
		
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			K = Integer.parseInt(parts[1]);
			
			numbers = new int[N];
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < N; ++i)
				numbers[i] = Integer.parseInt(parts[i]);
			
			for (int i = 0; i < MAXN; ++i)
				for (int j = 0; j < MAXM; ++j)
					memo[i][j] = -1;
			
			int ans = solve(0, 0);
			if (ans > 0)
				System.out.println("Divisible");
			else
				System.out.println("Not divisible");
		}
		
		in.close();
		System.exit(0);
	}
}
