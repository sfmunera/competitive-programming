package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 806 (865 - Substitution Cypher) */
/* SUBMISSION: 08959112 */
/* SUBMISSION TIME: 2011-06-17 04:00:27 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00865_SubstitutionCypher {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.nextLine());
		in.nextLine();
		
		boolean first = true;
		while (T-- > 0) {
			String plain = in.nextLine();
			String substitution = in.nextLine();
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(substitution);
			System.out.println(plain);
			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.isEmpty())
					break;
				char[] res = new char[line.length()];
				int k = 0;
				for (char c: line.toCharArray()) {
					int ind = plain.indexOf(c);
					if (ind < 0)
						res[k] = c;
					else
						res[k] = substitution.charAt(ind);
					++k;
				}
				System.out.println(String.valueOf(res));
			}
		}
	}
}