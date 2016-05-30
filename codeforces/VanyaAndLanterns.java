package codeforces;

import java.util.*;

public class VanyaAndLanterns {
	
	static final double EPSILON = 1e-9;
	
	static boolean check(int[] lanterns, int l, double d) {
		if (lanterns[0] - d > EPSILON) return false;
		if (lanterns[lanterns.length - 1] + d < l - EPSILON) return false;
		for (int i = 0; i < lanterns.length - 1; ++i) {
			if (lanterns[i] + d < lanterns[i + 1] - d - EPSILON) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int l = in.nextInt();
		int[] lanterns = new int[n];
		
		for (int i = 0; i < n; ++i) {
			lanterns[i] = in.nextInt();
		}
		
		Arrays.sort(lanterns);
		
		double ans = 0.0;
		double lo = 0.0;
		double hi = l;
		int maxIt = 100;
		while (hi - lo > EPSILON && maxIt > 0) {
			double mid = (lo + hi) / 2.0;
			if (check(lanterns, l, mid)) {
				hi = mid;
				ans = mid;
			} else {
				lo = mid;
			}
			--maxIt;
		}
		
		System.out.format("%.9f\n", ans);
		
		in.close();
		System.exit(0);
	}
}
