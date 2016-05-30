package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1641 (10700 - Camel trading) */
/* SUBMISSION: 09204335 */
/* SUBMISSION TIME: 2011-08-30 01:46:09 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10700_Cameltrading {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String expression = in.readLine();
			// Minimum
			long min = 0;
			for (String summand : expression.split("[+]")) {
				long prod = 1;
				for (String factor : summand.split("[*]"))
					prod *= Integer.parseInt(factor);
				min += prod;
			}
			// Maximum
			long max = 1;
			for (String factor : expression.split("[*]")) {
				long sum = 0;
				for (String summand : factor.split("[+]"))
					sum += Integer.parseInt(summand);
				max *= sum;
			}
			
			System.out.println("The maximum and minimum are " + max + " and " + min + ".");
		}
		
		in.close();
		System.exit(0);
	}
}