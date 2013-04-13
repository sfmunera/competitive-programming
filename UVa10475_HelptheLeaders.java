package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1416 (10475 - Help the Leaders) */
/* SUBMISSION: 11375749 */
/* SUBMISSION TIME: 2013-03-03 18:22:56 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10475_HelptheLeaders {
	
	static Item[] items;
	static boolean[][] prohibited;
	static int n, s;
	static Map<String, Integer> rank;
	
	static class Item implements Comparable<Item> {
		String s;
		public Item(String s) {
			this.s = s;
		}
		public int compareTo(Item p) {
			if (this.s.length() != p.s.length())
				return p.s.length() - this.s.length();
			return this.s.compareTo(p.s);
		}
		
	}
	
	static void go(String list, int cnt, int pos, int seen) {
		if (cnt == s) {
			System.out.println(list);
			return;
		}
		for (int i = pos + 1; i < items.length; ++i) {
			if ((seen & (1 << i)) == 0) {
				boolean ok = true;
				for (int j = 0; j < items.length; ++j) {
					int id1 = rank.get(items[i].s);
					int id2 = rank.get(items[j].s);
					if ((seen & (1 << j)) != 0 && prohibited[id1][id2]) {
						ok = false;
						break;
					}
				}
				if (!ok) continue;
				seen |= (1 << i);
				go(list + (cnt == 0 ? "" : " ") + items[i].s, cnt + 1, i, seen);
				seen &= ~(1 << i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			n = Integer.parseInt(stk.nextToken());
			int p = Integer.parseInt(stk.nextToken());
			s = Integer.parseInt(stk.nextToken());
			
			items = new Item[n];
			for (int i = 0; i < n; ++i)
				items[i] = new Item(in.readLine().toUpperCase());
			Arrays.sort(items);
			
			rank = new HashMap<String, Integer>();
			for (int i = 0; i < n; ++i)
				rank.put(items[i].s, i);
			
			prohibited = new boolean[n][n];
			for (int i = 0; i < p; ++i) {
				stk = new StringTokenizer(in.readLine());
				String word1 = stk.nextToken().toUpperCase();
				String word2 = stk.nextToken().toUpperCase();
				int id1 = rank.get(word1);
				int id2 = rank.get(word2);
				prohibited[id1][id2] = prohibited[id2][id1] = true;
			}
			
			System.out.println("Set " + t + ":");
			go("", 0, -1, 0);
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
