package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 581 (640 - Self Numbers) */
/* SUBMISSION: 08925298 */
/* SUBMISSION TIME: 2011-06-07 00:45:15 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00640_SelfNumbers {
	
	static int d(int n) {
		int res = n;
		
		while (n > 0) {
			res += n % 10;
			n /= 10;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Set<Integer> notSelf = new HashSet<Integer>();
		
		for (int k = 1; k <= 1e6; ++k)
			notSelf.add(d(k));
		
		for (int k = 1; k <= 1e6; ++k)
			if (!notSelf.contains(k))
				System.out.println(k);
	}
}