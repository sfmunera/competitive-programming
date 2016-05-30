package codeforces;

import java.util.*;

public class LuckySubstring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		int cnt4 = 0;
		int cnt7 = 0;
		
		// most frequent substring will always be '4' or '7'
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '4')
				++cnt4;
			else if (s.charAt(i) == '7')
				++cnt7;
		}
		if (cnt4 == 0 && cnt7 == 0) {
			System.out.println(-1);
		} else {
			if (cnt4 >= cnt7) {
				System.out.println(4);
			} else {
				System.out.println(7);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
