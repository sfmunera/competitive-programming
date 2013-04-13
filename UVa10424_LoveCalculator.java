package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1365 (10424 - Love Calculator) */
/* SUBMISSION: 09131053 */
/* SUBMISSION TIME: 2011-08-09 15:31:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10424_LoveCalculator {
	
	static int toNumber(String s) {
		int n = 0;
		
		for (char c : s.toCharArray())
			if (Character.isLetter(c))
				n += Character.toLowerCase(c) - 'a' + 1;
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String A = line;
			String B = in.readLine();
			
			int n1 = toNumber(A);
			int n2 = toNumber(B);
			
			while (n1 >= 10) {
				int sum = 0;
				while (n1 > 0) {
					sum += n1 % 10;
					n1 /= 10;
				}
				n1 = sum;
			}
			
			while (n2 >= 10) {
				int sum = 0;
				while (n2 > 0) {
					sum += n2 % 10;
					n2 /= 10;
				}
				n2 = sum;
			}
			
			System.out.printf(Locale.ENGLISH, "%.2f", 100.0 * (double)Math.min(n1, n2) / Math.max(n1, n2));
			System.out.println(" %");
		}
		
		in.close();
		System.exit(0);
	}
}