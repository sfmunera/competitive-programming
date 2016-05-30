package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 915 (974 - Kaprekar Numbers) */
/* SUBMISSION: 08926766 */
/* SUBMISSION TIME: 2011-06-07 14:43:08 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00974_KaprekarNumbers {
	
	static boolean isKaprekar(int n) {
		int sqr = n * n;
		String str = String.valueOf(sqr);
		
		for (int i = 1; i < str.length(); ++i) {
			int n1 = Integer.parseInt(str.substring(0, i));
			int n2 = Integer.parseInt(str.substring(i, str.length()));
			if (n1 > 0 && n2 > 0 && n1 + n2 == n)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean[] kaprekar = new boolean[40001];
		for (int i = 0; i <= 40000; ++i)
			if (isKaprekar(i))
				kaprekar[i] = true;
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int inf = in.nextInt();
			int sup = in.nextInt();
			
			if (t > 1)
				System.out.println();
			System.out.println("case #" + t);
			boolean found = false;
			for (int i = inf; i <= sup; ++i)
				if (kaprekar[i]) {
					found = true;
					System.out.println(i);
				}
			if (!found)
				System.out.println("no kaprekar numbers");
		}
	}
}
