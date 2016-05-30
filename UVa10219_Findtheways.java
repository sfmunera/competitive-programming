package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1160 (10219 - Find the ways !) */
/* SUBMISSION: 10415571 */
/* SUBMISSION TIME: 2012-07-31 19:11:36 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10219_Findtheways {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			long n = Long.parseLong(parts[0]);
			long k = Long.parseLong(parts[1]);
			
			double digits = 0.0;
			if (k > n - k)
				for (long i = k + 1; i <= n; ++i)
					digits += Math.log10(i) - Math.log10(i - k);
			else
				for (long i = n - k + 1; i <= n; ++i)
					digits += Math.log10(i) - Math.log10(i - n + k);
			sb.append(((long)Math.floor(digits) + 1) + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
