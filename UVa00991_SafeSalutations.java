package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 932 (991 - Safe Salutations) */
/* SUBMISSION: 10805550 */
/* SUBMISSION TIME: 2012-10-27 21:05:22 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00991_SafeSalutations {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 11;
		long[] C = new long[MAXN];
		C[0] = 1;
		
		for (int i = 0; i < MAXN - 1; ++i)
			C[i + 1] = C[i] * 2 * (2 * i + 1) / (i + 2);
		
		boolean first = true;
		String line;
		while ((line = in.readLine()) != null) {
			if (first)
				first = false;
			else {
				line = in.readLine();
				System.out.println();
			}
			
			int n = Integer.parseInt(line);
			System.out.println(C[n]);
		}
		
		in.close();
		System.exit(0);
	}
}
