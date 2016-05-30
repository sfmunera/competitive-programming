package codeforces;

import java.util.*;
import java.io.*;

public class NewspaperHeadline {
	
	static boolean valid(String s1, String s2) {
		boolean[] seen = new boolean[26];
		
		for (int i = 0; i < s1.length(); ++i) {
			seen[s1.charAt(i) - 'a'] = true;
		}
		
		for (int i = 0; i < s2.length(); ++i) {
			if (!seen[s2.charAt(i) - 'a']) return false;
		}
		
		return true;
	}
	
	static int solve(String s1, String s2) {
		Map<Character, List<Integer>> positions = new HashMap<Character, List<Integer>>();
		for (char c = 'a'; c <= 'z'; ++c) {
			positions.put(c, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < s1.length(); ++i) {
			positions.get(s1.charAt(i)).add(i);
		}
		
		int i1 = 0;
		int i2 = 0;
		
		int cnt = 1;
		while (i2 < s2.length()) {
			if (i1 == s1.length()) {
				++cnt;
				i1 = 0;
			}
			
			List<Integer> pos = positions.get(s2.charAt(i2));
			int p = -1;
			int lo = 0;
			int hi = pos.size() - 1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (pos.get(mid) >= i1) {
					p = pos.get(mid);
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			if (p < 0) {
				p = pos.get(0);
				++cnt;
			}
			i1 = p;
			if (s1.charAt(i1) == s2.charAt(i2)) {
				++i1; ++i2;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = in.readLine();
		String s2 = in.readLine();
		
		if (!valid(s1, s2)) {
			System.out.println(-1);
		} else {
			System.out.println(solve(s1, s2));
		}
		
		in.close();
		System.exit(0);
	}
}
