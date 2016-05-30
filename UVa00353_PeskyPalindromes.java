package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 289 (353 - Pesky Palindromes) */
/* SUBMISSION: 08961048 */
/* SUBMISSION TIME: 2011-06-17 15:02:31 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00353_PeskyPalindromes {
	
	static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		
		for (int i = 0; i < n / 2; ++i)
			if (c[i] != c[n - i - 1])
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String word = in.next();
			Set<String> pals = new HashSet<String>();
			
			for (int i = 0; i < word.length(); ++i)
				for (int j = i + 1; j <= word.length(); ++j) {
					String piece = word.substring(i, j);
					if (isPalindrome(piece))
						pals.add(piece);
				}
			System.out.println("The string '" + word + "' contains " + pals.size() + " palindromes.");
		}
	}
}