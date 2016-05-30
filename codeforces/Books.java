package codeforces;

import java.util.*;

public class Books {
	
	static boolean can(int[] a, int[] f, int t, int max) {
		for (int i = 1; i + max - 1 <= a.length - 1; ++i) {
			if (f[i + max - 1] - f[i - 1] <= t) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int t = in.nextInt();
		int[] a = new int[n + 1];
		int[] f = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			a[i] = in.nextInt();
			f[i] = f[i - 1] + a[i];
		}

		int lo = 1;
		int hi = n;
		int ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (can(a, f, t, mid)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
