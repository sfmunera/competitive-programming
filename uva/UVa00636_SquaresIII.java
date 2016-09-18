package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 577 (636 - Squares (III)) */
/* SUBMISSION: 08927725 */
/* SUBMISSION TIME: 2011-06-07 21:46:24 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00636_SquaresIII {
	
	static long toBase(String n, int b) {
		int mult = 1;
		long res = 0;
		
		for (int i = n.length() - 1; i >= 0; --i) {
			res += (n.charAt(i) - '0') * mult;
			mult *= b;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			String nstr = in.next();
			if (nstr.equals("0"))
				break;

			int b = 2;
			for (int i = 0; i < nstr.length(); ++i)
				b = Math.max(b, nstr.charAt(i) - '0' + 1);
			while (true) {
				long n = toBase(nstr, b);
				long sqrt = Math.round(Math.sqrt(n));
				
				if (sqrt * sqrt == n) {
					System.out.println(b);
					break;
				}
				++b;
			}
		}
	}
}