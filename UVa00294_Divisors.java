package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 230 (294 - Divisors) */
/* SUBMISSION: 09081741 */
/* SUBMISSION TIME: 2011-07-26 15:10:41 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00294_Divisors {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int L = Integer.parseInt(stk.nextToken());
			int U = Integer.parseInt(stk.nextToken());
			
			int max = 0;
			int maxnum = 0;
			for (int i = L; i <= U; ++i) {
				int x = i;
				
				int nDiv = 1;
				for (int p = 2; p * p <= x; ++p) {
					int cnt = 0;
					while (x % p == 0) {
						++cnt;
						x /= p;
					}
					nDiv *= cnt + 1;
				}
				if (x > 1)
					nDiv *= 2;
				
				if (nDiv > max) {
					max = nDiv;
					maxnum = i;
				}
			}
			System.out.println("Between " + L + " and " + U + ", " + maxnum + " has a maximum of " + max + " divisors.");
		}
		
		in.close();
		System.exit(0);
	}
}