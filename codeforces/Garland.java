package codeforces;

import java.util.*;

public class Garland {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String vasya = in.next();
		String garland = in.next();
		int[] cntVasya = new int[26];
		int[] cntGarland = new int[26];
		
		for (int i = 0; i < vasya.length(); ++i)
			cntVasya[vasya.charAt(i) - 'a']++;
		for (int i = 0; i < garland.length(); ++i)
			cntGarland[garland.charAt(i) - 'a']++;
		
		int ans = 0;
		for (int i = 0; i < 26; ++i) {
			if (cntGarland[i] > 0 && cntVasya[i] == 0) {
				ans = -1;
				break;
			}
			ans += Math.min(cntGarland[i], cntVasya[i]);
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
