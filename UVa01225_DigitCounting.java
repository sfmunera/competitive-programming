package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3666 (1225 - Digit Counting) */
/* SUBMISSION: 11413223 */
/* SUBMISSION TIME: 2013-03-10 05:32:12 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa01225_DigitCounting {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int[] cnt = new int[10];
			
			for (int i = 1; i <= N; ++i) {
				int x = i;
				while (x > 0) {
					++cnt[x % 10];
					x /= 10;
				}
			}
			System.out.print(cnt[0]);
			for (int i = 1; i < 10; ++i)
				System.out.print(" " + cnt[i]);
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
