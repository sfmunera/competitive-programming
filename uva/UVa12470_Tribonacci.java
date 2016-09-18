package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3914 (12470 - Tribonacci) */
/* SUBMISSION: 10187136 */
/* SUBMISSION TIME: 2012-06-03 19:08:05 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12470_Tribonacci {
	
	static final int MOD = 1000000009;
	
	static long[][] eye(int N) {
		long[][] I = new long[N][N];
		for (int i = 0; i < N; ++i)
			I[i][i] = 1;
		return I;
	}
	
	static long[][] multiply(long[][] A, long[][] B) {
		int N = A.length;
		long[][] C = new long[N][N];
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				for (int k = 0; k < N; ++k)
					C[i][j] = (C[i][j] + ((A[i][k] % MOD) * (B[k][j] % MOD)) % MOD) % MOD;
		
		return C;
	}
	
	static long[][] fastPow(long[][] A, long N) {
		if (N == 0)
			return eye(3);
		if (N == 1)
			return A;
		if (N % 2 == 0) {
			long[][] tmp = fastPow(A, N / 2);
			return multiply(tmp, tmp);
		} else {
			long[][] tmp = fastPow(A, (N - 1) / 2);
			return multiply(A, multiply(tmp, tmp));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		while (true) {
			long N = Long.parseLong(in.readLine());
			if (N == 0)
				break;

			long ans = 0;
			if (N <= 3)
				ans = (int)(N - 1);
			else {
			
				long[][] A = new long[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}};
				long[][] pow = fastPow(A, N - 3);
				
				ans = (pow[2][1] + (2 * (pow[2][2] % MOD)) % MOD) % MOD;
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
