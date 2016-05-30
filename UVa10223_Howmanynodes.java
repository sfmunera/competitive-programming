package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1164 (10223 - How many nodes ?) */
/* SUBMISSION: 10805531 */
/* SUBMISSION TIME: 2012-10-27 20:56:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10223_Howmanynodes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 20;
		long[] C = new long[MAXN];
		C[0] = 1;
		for (int i = 0; i < MAXN - 1; ++i)
			C[i + 1] = C[i] * 2 * (2 * i + 1) / (i + 2);
		String line;
		while ((line = in.readLine()) != null) {
			long n = Long.parseLong(line);
			int ind = 0;
			for (int i = 0; i < MAXN; ++i)
				if (C[i] == n)
					ind = i;
			System.out.println(ind);
		}
		
		in.close();
		System.exit(0);
	}
}