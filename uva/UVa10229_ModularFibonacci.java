package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1170 (10229 - Modular Fibonacci) */
/* SUBMISSION: 10094288 */
/* SUBMISSION TIME: 2012-05-09 20:32:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10229_ModularFibonacci {
	
	static long[][] multiply(long[][] A, long[][] B, long mod) {
		long[][] C = new long[2][2];
		for (int i = 0; i < 2; ++i)
			for (int j = 0; j < 2; ++j)
				for (int k = 0; k < 2; ++k)
					C[i][j] = (C[i][j] + ((A[i][k] % mod) * (B[k][j] % mod)) % mod) % mod;
		
		return C;
	}
	
	static long[][] fastPow(long[][] base, long exp, long mod) {
		if (exp < 0)
			return new long[][]{{0, 0}, {0, 0}};
		if (exp == 0)
			return new long[][]{{1, 0}, {0, 1}};
		if (exp == 1)
			return base;
		
		if (exp % 2 == 0) {
			long[][] tmp = fastPow(base, exp / 2, mod);
			return multiply(tmp, tmp, mod);
		} else {
			long[][] tmp = fastPow(base, (exp - 1) / 2, mod);
			return multiply(base, multiply(tmp, tmp, mod), mod);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			line = line.trim();
			String[] parts = line.split("[ ]+");
			long N = Long.parseLong(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			long MOD = (1L << M);
			
			long[][] base = {{0L, 1L}, {1L, 1L}};
			long[][] pow = fastPow(base, N - 1, MOD);
			
			long res = pow[1][1];
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
