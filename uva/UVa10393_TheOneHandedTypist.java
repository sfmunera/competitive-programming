package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1334 (10393 - The One-Handed Typist) */
/* SUBMISSION: 10184428 */
/* SUBMISSION TIME: 2012-06-03 01:16:25 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10393_TheOneHandedTypist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "qaz");
		map.put(2, "wsx");
		map.put(3, "edc");
		map.put(4, "rfvtgb");
		map.put(5, "");
		map.put(6, "");
		map.put(7, "yhnujm");
		map.put(8, "ik");
		map.put(9, "ol");
		map.put(10, "p");
		
		while (sc.hasNextInt()) {
			int F = sc.nextInt();
			int N = sc.nextInt();
			
			String forbidden = "";
			for (int i = 0; i < F; ++i)
				forbidden += map.get(sc.nextInt());
			
			Set<String> words = new TreeSet<String>();
			for (int i = 0; i < N; ++i)
				words.add(sc.next());
			
			List<String> ans = new ArrayList<String>();
			int maxlen = 0;
			for (String w : words) {
				boolean ok = true;
				for (int i = 0; i < forbidden.length() && ok; ++i)
					if (w.contains("" + forbidden.charAt(i)))
						ok = false;
				if (ok) {
					ans.add(w);
					maxlen = Math.max(maxlen, w.length());
				}
			}
			
			List<String> sel = new ArrayList<String>();
			for (String a : ans)
				if (a.length() == maxlen)
					sel.add(a);
			
			System.out.println(sel.size());
			for (String a : sel)
				System.out.println(a);
		}
		
		System.exit(0);
	}
}
