package tju;

import java.io.*;
import java.util.*;

public class AnagramGroups {
	
	static class Item implements Comparable<Item> {
		TreeSet<String> set;
		int cnt;
		public Item() {
			set = new TreeSet<String>();
			cnt = 0;
		}
		public int compareTo(Item i) {
			if (i.cnt != this.cnt) return i.cnt - this.cnt;
			if (i.set.size() > 0) {
				String s1 = "", s2 ="";
				for (String s : this.set) {
					s1 = s;
					break;
				}
				for (String s : i.set) {
					s2 = s;
					break;
				}
				return s1.compareTo(s2);
			}
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		Map<String, Item> map = new HashMap<String, Item>();
		while (in.hasNext()) {
			String word = in.next();
			char[] ordered = word.toCharArray();
			Arrays.sort(ordered);
			String s = String.valueOf(ordered);
			
			if (!map.containsKey(s))
				map.put(s, new Item());
			map.get(s).set.add(word);
			++map.get(s).cnt;
		}
		
		TreeSet<Item> sets = new TreeSet<Item>();
		for (String s : map.keySet())
			sets.add(map.get(s));
		
		int cnt = 0;
		for (Item it : sets) {
			if (cnt >= 5) break;
			System.out.print("Group of size " + it.cnt + ":");
			for (String s : it.set)
				System.out.print(" " + s);
			System.out.println(" .");
			++cnt;
		}
		
		in.close();
		System.exit(0);
	}
}
