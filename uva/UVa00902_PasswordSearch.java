package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 843 (902 - Password Search) */
/* SUBMISSION: 08959101 */
/* SUBMISSION TIME: 2011-06-17 03:48:08 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00902_PasswordSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int n = in.nextInt();
			String text = in.next();
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < text.length() - n; ++i) {
				String piece = text.substring(i, i + n);
				if (map.containsKey(piece))
					map.put(piece, map.get(piece) + 1);
				else
					map.put(piece, 1);
			}
			int max = 0;
			String password = "";
			for (String piece : map.keySet()) {
				int value = map.get(piece); 
				if (value > max) {
					max = value;
					password = piece;
				}
			}
			System.out.println(password);
		}
	}
}
