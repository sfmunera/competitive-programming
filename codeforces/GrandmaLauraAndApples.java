package codeforces;

import java.util.*;

public class GrandmaLauraAndApples {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int p = in.nextInt();
		
		boolean[] hasGift = new boolean[n];
		for (int i = 0; i < n; ++i) {
			String s = in.next();
			hasGift[i] = s.equals("halfplus");
		}
		
		long ans = 0;
		assert hasGift[hasGift.length - 1];
		
		long[] num = new long[n];
		for (int i = hasGift.length - 1; i >= 0; --i) {
			if (i == hasGift.length - 1) num[i] = 1L;
			else {
				if (hasGift[i]) num[i] = 2L * (long)num[i + 1] + 1;
				else num[i] = 2L * (long)num[i + 1];
			}
		}
		
		for (int i = 0; i < n; ++i) {
			ans += (long) p / 2L * num[i];
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
