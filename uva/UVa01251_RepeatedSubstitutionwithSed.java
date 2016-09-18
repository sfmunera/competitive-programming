package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3692 (1251 - Repeated Substitution with Sed) */
/* SUBMISSION: 09291223 */
/* SUBMISSION TIME: 2011-09-23 02:06:42 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa01251_RepeatedSubstitutionwithSed {
	
	private static String[] from;
	private static String[] to;
	private static String src;
	private static String dest;
	
	static int f(String src, String dest) {
		if (src.equals(dest)) return 0;
		if (src.length() > dest.length()) return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < from.length; ++i) {
			String tmp = src.replaceAll(from[i], to[i]);
			if (!src.equals(tmp)) {
				int res = f(tmp, dest);
				if (res != Integer.MAX_VALUE)
					min = Math.min(min, 1 + res);
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int n = in.nextInt();
			if (n == 0) break;
			
			from = new String[n];
			to = new String[n];
			
			for (int i = 0; i < n; ++i) {
				from[i] = in.next();
				to[i] = in.next();
			}
			String src = in.next();
			String dest = in.next();
			
			int res = f(src, dest);
			res = res == Integer.MAX_VALUE ? -1 : res;
			System.out.println(res);
		}
		
	}
}