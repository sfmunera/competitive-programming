package codeforces;

import java.util.*;

public class RoadsideTrees {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] h = new int[n];
		
		for (int i = 0; i < n; ++i) {
			h[i] = in.nextInt();
		}
		
		int ans = h[0];
		for (int i = 1; i < n; ++i) {
			ans += Math.abs(h[i - 1] - h[i]);
		}
		// time to eat the nuts
		ans += n;
		// time to jump to next tree
		ans += n - 1;
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
