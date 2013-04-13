package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 948 (10007 - Count the Trees) */
/* SUBMISSION: 10796787 */
/* SUBMISSION TIME: 2012-10-26 00:52:27 */
/* LANGUAGE: 2 */

import java.io.*;
import java.math.*;

public class UVa10007_CounttheTrees {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 605;
		BigInteger[][] C = new BigInteger[MAXN][MAXN];
		BigInteger[] fac = new BigInteger[MAXN];
		
		fac[0] = BigInteger.ONE;
		for (int i = 0; i < MAXN; ++i) {
			C[i][0] = C[i][i] = BigInteger.ONE;
			if (i > 0)
				fac[i] = fac[i - 1].multiply(BigInteger.valueOf(i));
		}
		
		for (int i = 2; i < MAXN; ++i)
			for (int j = 1; j < i; ++j)
				C[i][j] = C[i - 1][j].add(C[i - 1][j - 1]);

		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			BigInteger ntrees = fac[N].multiply(C[2 * N][N].divide(BigInteger.valueOf(N + 1)));
			System.out.println(ntrees);
		}
		
		in.close();
		System.exit(0);
	}
}
