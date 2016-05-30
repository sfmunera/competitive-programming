package codeforces;

import java.util.*;

public class PowerConsumptionCalculation {
	
	static class Interval {
		int l, r;
		Interval(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] P = new int[3];
		int[] T = new int[3];
		P[0] = in.nextInt();
		P[1] = in.nextInt();
		P[2] = in.nextInt();
		T[0] = in.nextInt();
		T[1] = in.nextInt();
		
		Interval[] intervals = new Interval[n + 1];
		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			int l = in.nextInt();
			int r = in.nextInt();
			
			intervals[i] = new Interval(l, r);
			ans += P[0] * (intervals[i].r - intervals[i].l);
		}

		for (int i = 1; i < n; ++i) {
			int left = intervals[i + 1].l - intervals[i].r;
			ans += Math.min(left, T[0]) * P[0];
			left -= Math.min(left, T[0]);
			ans += Math.min(left, T[1]) * P[1];
			left -= Math.min(left, T[1]);
			ans += Math.max(0, left) * P[2];
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
