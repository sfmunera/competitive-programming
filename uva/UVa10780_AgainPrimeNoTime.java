package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1721 (10780 - Again Prime? No Time.) */
/* SUBMISSION: 10205061 */
/* SUBMISSION TIME: 2012-06-08 19:35:26 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10780_AgainPrimeNoTime {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().trim().split("[ ]+");
			int m = Integer.parseInt(parts[0]);
			int n = Integer.parseInt(parts[1]);
			
			int[] primeCnt = new int[10000];
			for (int i = 2; i <= n; ++i) {
				int tmp = i;
				for (int p = 2; p * p <= tmp; ++p)
					while (tmp % p == 0) {
						++primeCnt[p];
						tmp /= p;
					}
				if (tmp > 1)
					++primeCnt[tmp];
			}
			
			int min = Integer.MAX_VALUE;
			for (int p = 2; p * p <= m; ++p) {
				int cnt = 0;
				while (m % p == 0) {
					++cnt;
					m /= p;
				}
				if (cnt > 0)
					min = Math.min(min, primeCnt[p] / cnt);
			}
			if (m > 1)
				min = Math.min(min, primeCnt[m]);
			System.out.println("Case " + t + ":");
			if (min == 0)
				System.out.println("Impossible to divide");
			else
				System.out.println(min);
		}
		
		in.close();
		System.exit(0);
	}
}
