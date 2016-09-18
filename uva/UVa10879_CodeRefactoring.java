package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1820 (10879 - Code Refactoring) */
/* SUBMISSION: 11413049 */
/* SUBMISSION TIME: 2013-03-10 04:41:23 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10879_CodeRefactoring {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; ++t) {
			int K = Integer.parseInt(in.readLine());
			int[] factors = new int[4];
			
			int j = 0;
			for (int i = 2; i * i <= K; ++i) {
				if (K % i == 0) {
					factors[j++] = i;
					factors[j++] = K / i;
				}
				if (j == 4) break;
			}
			
			sb.append(String.format("Case #%d: %d = %d * %d = %d * %d\n", t, K, factors[0], factors[1], factors[2], factors[3]));
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
