package leetcode;

import java.util.*;

public class LC455_AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int ans = 0;
		int cookieIndex = 0;
		for (int i = 0; i < g.length; i++) {
			while (cookieIndex < s.length && s[cookieIndex] < g[i]) {
				cookieIndex++;
			}
			if (cookieIndex == s.length) {
				break;
			}
			ans++;
			cookieIndex++;
		}
		return ans;
	}
}
