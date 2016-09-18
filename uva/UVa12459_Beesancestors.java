package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3890 (12459 - Bees' ancestors) */
/* SUBMISSION: 10124562 */
/* SUBMISSION TIME: 2012-05-17 15:39:50 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12459_Beesancestors {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long[] fib = new long[81];
		fib[0] = 1;
		fib[1] = 1;
		
		for (int i = 2; i <= 80; ++i)
			fib[i] = fib[i - 1] + fib[i - 2];
		
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;
			
			System.out.println(fib[n]);
		}
		
		in.close();
		System.exit(0);
	}
}
