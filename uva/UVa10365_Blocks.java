package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1306 (10365 - Blocks) */
/* SUBMISSION: 09959340 */
/* SUBMISSION TIME: 2012-04-05 20:20:35 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10365_Blocks {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int res = Integer.MAX_VALUE;
			
			for (int a = 1; a <= N; ++a)
				for (int b = 1; b <= N; ++b) {
					if (N % (a * b) != 0)
						continue;
					
					int c = N / (a * b);
					res = Math.min(res, 2 * (a * b + a * c + b * c));
				}
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
