package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3106 (11955 - Binomial Theorem) */
/* SUBMISSION: 10415751 */
/* SUBMISSION TIME: 2012-07-31 20:05:54 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11955_BinomialTheorem {
	
	public static void main(String[] args) throws IOException {
		int MAXN = 55;
		long[][] C = new long[MAXN][MAXN];
		for (int i = 0; i < MAXN; ++i)
			C[i][0] = C[i][i] = 1;
		for (int i = 2; i < MAXN; ++i)
			for (int j = 1; j < i; ++j)
				C[i][j] = C[i - 1][j - 1] + C[i - 1][j];

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String exp = in.readLine();
			String[] parts = exp.split("[\\^]");
			int k = Integer.parseInt(parts[1]);
			parts = parts[0].substring(1, parts[0].length() - 1).split("[+]");
			
			String a = parts[0];
			String b = parts[1];
			
			sb.append("Case " + t + ": ");
			for (int i = 0; i <= k; ++i) {
				if (i > 0) sb.append("+");
				if (C[k][i] > 1) sb.append(C[k][i] + "*");
				if (k - i > 0) {
					sb.append(a);
					if (k - i > 1)
						sb.append("^" + (k - i));
				}
				if (i > 0) {
					if (k - i > 0 && C[k][i] > 1) sb.append("*");
					sb.append(b);
					if (i > 1)
						sb.append("^" + i);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}