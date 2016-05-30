package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2307 (11332 - Summing Digits) */
/* SUBMISSION: 09163745 */
/* SUBMISSION TIME: 2011-08-17 21:42:31 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11332_SummingDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			while (N > 9) {
				int sum = 0;
				while (N > 0) {
					sum += N % 10;
					N /= 10;
				}
				N = sum;
			}
			System.out.println(N);
		}
		
		in.close();
		System.exit(0);
	}
}