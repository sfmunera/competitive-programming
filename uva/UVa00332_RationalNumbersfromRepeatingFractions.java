package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 268 (332 - Rational Numbers from Repeating Fractions) */
/* SUBMISSION: 09153245 */
/* SUBMISSION TIME: 2011-08-15 14:50:55 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00332_RationalNumbersfromRepeatingFractions {
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		int t = 1;
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int j = Integer.parseInt(stk.nextToken());
			if (j == -1)
				break;
				
			String X = stk.nextToken();
			int k = X.length() - j - 2;

			long powk = 1;
			for (int i = 0; i < k; ++i)
				powk *= 10;
			long powj = 1;
			for (int i = 0; i < j; ++i)
				powj *= 10;
			long powkj = powk * powj;
				
			long m = Math.round(Double.parseDouble(X) * powkj);
				
			long num = 0;
			long den = 0;
			
			if (powkj == powk) {
				num = m;
				den = powkj;
			} else {
				num = (long)(m - m / powj);
				den = (long)(powkj - powk);
			}
			//System.out.println(Double.parseDouble(X) + ", " + m + ", " + m / powj);
			long gcd = gcd(num, den);
			num /= gcd;
			den /= gcd;
				
			System.out.println("Case " + t++ + ": " + num + "/" + den);
		}
		
		in.close();
		System.exit(0);
	}
}
