package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 524 (583 - Prime Factors) */
/* SUBMISSION: 09081798 */
/* SUBMISSION TIME: 2011-07-26 15:27:17 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00583_PrimeFactors {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			long N = Long.parseLong(in.readLine());
			if (N == 0)
				break;
			
			StringBuilder res = new StringBuilder();
			boolean first = true;
			
			res.append(N + " = ");
			if (N < 0) {
				first = false;
				res.append(-1);
				N *= -1;
			}
			
			for (long p = 2; p * p <= N; ++p)
				while (N % p == 0) {
					if (first)
						first = false;
					else
						res.append(" x ");
					res.append(p);
					
					N /= p;
				}
			if (N > 1) {
				if (first)
					first = false;
				else
					res.append(" x ");
				res.append(N);
			}
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
