package codeforces;

import java.util.*;

public class FindMarble {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		
		int[] p = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			p[i] = in.nextInt();
		}
		
		Set<Integer> seen = new HashSet<Integer>();		
		int cur = s;
		int cnt = 0;
		int ans = -1;
		while (!seen.contains(cur)) {
			if (cur == t) {
				ans = cnt;
				break;
			}
			seen.add(cur);
			cur = p[cur];
			++cnt;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
