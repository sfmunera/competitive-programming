package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1042 (10101 - Bangla Numbers) */
/* SUBMISSION: 08927249 */
/* SUBMISSION TIME: 2011-06-07 18:02:28 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10101_BanglaNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (in.hasNextLong()) {
			long n = in.nextLong();
			String[] names = {"shata", "hajar", "lakh", "kuti"};
			int[] mods = {10, 100, 100, 100};
			int ind = 0;
			
			if (n == 0) {
				System.out.printf("%4d. %d%n", t, n);
			} else {
				List<Long> parts = new ArrayList<Long>();
				parts.add(n % 100);
				n /= 100;
				while (n > 0) {
					parts.add(n % mods[ind]);
					n /= mods[ind];
					ind = (ind + 1) % 4;
				}
				ind = 0;
				StringBuilder sb = new StringBuilder();
				if (parts.get(0) != 0)
					sb.append(" " + parts.get(0));
				for (int i = 1; i < parts.size(); ++i) {
					if (parts.get(i) == 0 && (i - 1) % 4 == 3)
						sb.insert(0, " " + names[(i - 1) % 4]);
					else if (parts.get(i) != 0)
						sb.insert(0, " " + parts.get(i) + " " + names[(i - 1) % 4]);
						
				}
				System.out.printf("%4d.%s%n", t, sb.toString());
			}
			++t;
		}
	}
}