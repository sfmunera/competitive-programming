package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2461 (11466 - Largest Prime Divisor) */
/* SUBMISSION: 09153879 */
/* SUBMISSION TIME: 2011-08-15 18:04:24 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11466_LargestPrimeDivisor {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			long N = Long.parseLong(in.readLine());
			if (N == 0)
				break;
			N = Math.abs(N);

			long max = 0;
			int cnt = 0;
			for (long p = 2; p * p <= N; ++p) {
				if (N % p == 0) {
					++cnt;
					max = Math.max(max, p);
				}
				while (N % p == 0)
					N /= p;
			}
			if (N > 1) {
				++cnt;
				max = Math.max(max, N);
			}
			
			System.out.println(cnt > 1 ? max : -1);
		}
		
		in.close();
		System.exit(0);
	}
}