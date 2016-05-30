package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 471 (530 - Binomial Showdown) */
/* SUBMISSION: 10415935 */
/* SUBMISSION TIME: 2012-07-31 20:53:36 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00530_BinomialShowdown {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int n = Integer.parseInt(parts[0]);
			int k = Integer.parseInt(parts[1]);
			
			if (n == 0 && k == 0) break;
			
			long ans = 1;
			k = Math.min(k, n - k);
			for (int i = 1; i <= k; ++i) {
				ans *= (n - k + i);
				ans /= i;
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
