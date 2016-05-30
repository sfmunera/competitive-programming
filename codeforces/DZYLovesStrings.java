package codeforces;

import java.util.*;

public class DZYLovesStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		int k = in.nextInt();
		
		int max = 0;
		int[] values = new int[26];
		for (int i = 0; i < 26; ++i) {
			values[i] = in.nextInt();
			max = Math.max(max, values[i]);
		}
		
		int ans = 0;
		// value of the original string
		for (int i = 1; i <= s.length(); ++i) {
			ans += i * values[s.charAt(i - 1) - 'a'];
		}
		
		// just put the max value in the end of the string
		for (int i = 0; i < k; ++i) {
			ans += (i + 1 + s.length()) * max;
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
