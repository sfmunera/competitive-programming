package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 439 (498 - Polly the Polynomial) */
/* SUBMISSION: 10142061 */
/* SUBMISSION TIME: 2012-05-22 14:22:48 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00498_PollythePolynomial {
	
	static int fastPow(int x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		
		if (n % 2 == 0)
			return fastPow(x * x, n / 2);
		else
			return x * fastPow(x * x, (n - 1) / 2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			String[] cstr = line.split("[ ]+");
			String[] xstr = in.readLine().split("[ ]+");
			
			int n = cstr.length - 1;
			int[] c = new int[n + 1];
			
			for (int i = 0; i <= n; ++i)
				c[i] = Integer.parseInt(cstr[i]);
			
			for (int i = 0; i < xstr.length; ++i) {
				int x = Integer.parseInt(xstr[i]);
				int res = 0;
				for (int j = n; j >= 0; --j) {
					int term = c[n - j] * fastPow(x, j);
					res += term;
				}
				if (i > 0)
					sb.append(" ");
				sb.append(res);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
