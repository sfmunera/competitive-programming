package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3155 (12004 - Bubble Sort) */
/* SUBMISSION: 10242318 */
/* SUBMISSION TIME: 2012-06-20 13:46:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12004_BubbleSort {
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			long N = Long.parseLong(in.readLine());
			
			long num = N * (N - 1);
			int den = 4;
			long gcd = gcd(num, den);
			
			num /= gcd;
			den /= gcd;
			String frac = num + (den != 1 ? ("/" + den) : "");
			System.out.printf("Case %d: %s\n", t, "" + frac);
		}
		

		in.close();
		System.exit(0);
	}
}
