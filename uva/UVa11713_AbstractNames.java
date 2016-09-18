package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2760 (11713 - Abstract Names) */
/* SUBMISSION: 08955193 */
/* SUBMISSION TIME: 2011-06-15 22:36:14 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11713_AbstractNames {
	
	static boolean isConsonant(char c) {
		return Character.isLetter(c) && c != 'a' && c != 'e' && 
										c != 'i' && c != 'o' && c != 'u';
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			String real = in.next();
			String game = in.next();
			boolean valid = real.length() == game.length();
			
			for (int i = 0; i < real.length() && valid; ++i) {
				char c1 = real.charAt(i);
				char c2 = game.charAt(i);
				if (isConsonant(c1) && c1 != c2)
					valid = false;
			}
			System.out.println(valid ? "Yes" : "No");
		}
	}
}