package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1333 (10392 - Factoring Large Numbers) */
/* SUBMISSION: 09120883 */
/* SUBMISSION TIME: 2011-08-06 16:07:14 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10392_FactoringLargeNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			long N = Long.parseLong(in.readLine());
			if (N < 0)
				break;
			
			for (int p = 2; p <= 1000000; ++p)
				while (N % p == 0) {
					System.out.println("    " + p);
					N /= p;
				}
			if (N > 1)
				System.out.println("    " + N);
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}