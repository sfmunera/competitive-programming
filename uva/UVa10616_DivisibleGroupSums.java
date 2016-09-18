package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1557 (10616 - Divisible Group Sums) */
/* SUBMISSION: 10224796 */
/* SUBMISSION TIME: 2012-06-14 18:58:36 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10616_DivisibleGroupSums {
	
	static int M, N, D;
	static int[] set;
	static int[][][] memo;
	
	static int solve(int id, int k, int sum) {
		sum = (sum % D + D) % D;
		if (k == M && sum == 0)
			return 1;
		if (k == M)
			return 0;
		if (id == N)
			return 0;
		
		if (memo[id][k][sum] != -1)
			return memo[id][k][sum];
		
		return memo[id][k][sum] = solve(id + 1, k + 1, (sum + set[id] % D) % D) + 
		                          solve(id + 1, k, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 205;
		int MAXM = 15;
		int MAXS = 25;
		
		memo = new int[MAXN][MAXM][MAXS];
		
		int t = 1;
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int Q = Integer.parseInt(parts[1]);
			
			if (N == 0 && Q == 0)
				break;
			
			set = new int[N];
			for (int i = 0; i < N; ++i)
				set[i] = Integer.parseInt(in.readLine());
			
			
			
			System.out.println("SET " + t + ":");
			for (int q = 1; q <= Q; ++q) {
				parts = in.readLine().split("[ ]+");
				D = Integer.parseInt(parts[0]);
				M = Integer.parseInt(parts[1]);
				
				for (int i = 0; i < MAXN; ++i)
					for (int j = 0; j < MAXM; ++j)
						for (int k = 0; k < MAXS; ++k)
							memo[i][j][k] = -1;
				
				System.out.println("QUERY " + q + ": " + solve(0, 0, 0));
				
			}
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
