package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2347 (11362 - Phone List) */
/* SUBMISSION: 08955304 */
/* SUBMISSION TIME: 2011-06-15 23:46:48 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11362_PhoneList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while (T-- > 0) {
			int N = in.nextInt();
			String[] phones = new String[N];
			
			for (int i = 0; i < N; ++i)
				phones[i] = in.next();
			Arrays.sort(phones);
			
			boolean valid = true;
			for (int i = 1; i < N && valid; ++i) {
				if (phones[i].length() > phones[i - 1].length() && 
						phones[i].substring(0, phones[i - 1].length()).equals(phones[i - 1]))
					valid = false;
			}
				
			System.out.println(valid ? "YES" : "NO");
		}
	}
}