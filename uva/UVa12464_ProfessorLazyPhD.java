package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3907 (12464 - Professor Lazy, Ph.D.) */
/* SUBMISSION: 10187130 */
/* SUBMISSION TIME: 2012-06-03 19:05:49 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12464_ProfessorLazyPhD {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int alpha = Integer.parseInt(parts[0]);
			int beta = Integer.parseInt(parts[1]);
			long n = Long.parseLong(parts[2]);
			
			if (alpha == 0 && beta == 0 && n == 0)
				break;
			
			int mod = (int)(n % 5);
			int ans = 0;
			
			
			switch (mod) {
			case 0:
				ans = alpha;
				break;
			case 1:
				ans = beta;
				break;
			case 2:
				ans = (1 + beta) / alpha;
				break;
			case 3:
				ans = (1 + alpha + beta) / (alpha * beta);
				break;
			case 4:
				ans = (1 + alpha) / beta;
				break;
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
