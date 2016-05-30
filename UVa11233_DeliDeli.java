package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2174 (11233 - Deli Deli) */
/* SUBMISSION: 08955387 */
/* SUBMISSION TIME: 2011-06-16 00:38:50 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11233_DeliDeli {
	
	static boolean isConsonant(char c) {
		return Character.isLetter(c) && c != 'a' && c != 'e' && 
										c != 'i' && c != 'o' && c != 'u';
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int L = in.nextInt();
		int N = in.nextInt();
		Map<String, String> irregular = new HashMap<String, String>();
		
		for (int i = 0; i < L; ++i)
			irregular.put(in.next(), in.next());
		for (int i = 0; i < N; ++i) {
			String word = in.next();
			int n = word.length();
			char last = word.charAt(n - 1);
			
			if (irregular.containsKey(word))
				System.out.println(irregular.get(word));
			else if (last == 'y' && n >= 2 && isConsonant(word.charAt(n - 2)))
				System.out.println(word.substring(0, n - 1) + "ies");
			else if (last == 'o' || last == 's' || last == 'x' || 
					(last == 'h' && n >= 2 && 
							(word.charAt(n - 2) == 'c' || word.charAt(n - 2) == 's')))
				System.out.println(word + "es");
			else
				System.out.println(word + "s");
		}
	}
}