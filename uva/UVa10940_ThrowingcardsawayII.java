package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1881 (10940 - Throwing cards away II) */
/* SUBMISSION: 10177952 */
/* SUBMISSION TIME: 2012-06-01 05:02:54 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10940_ThrowingcardsawayII {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			int ans = 2 * (N - Integer.highestOneBit(N));
			if (ans == 0)
				ans = N;
			sb.append(ans + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
