package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1332 (10391 - Compound Words) */
/* SUBMISSION: 08959081 */
/* SUBMISSION TIME: 2011-06-17 03:31:07 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10391_CompoundWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<String> dict = new ArrayList<String>();
		while (in.hasNextLine())
			dict.add(in.nextLine());
		
		int n = dict.size();
		for (int i = 0; i < n; ++i) {
			String w = dict.get(i);
			int m = w.length();
			for (int j = 1; j < m; ++j) {
				String pref = w.substring(0, j);
				String suf = w.substring(j, m);
				if (Collections.binarySearch(dict, pref) >= 0 &&
						Collections.binarySearch(dict, suf) >= 0) {
					System.out.println(w);
					break;
				}
					
			}
		}
	}
}