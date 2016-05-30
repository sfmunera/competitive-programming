package codeforces;

import java.util.*;

public class NearestFraction {
	
	static int bestNum, bestDen, x, y;
	static double best;
	
	static void updateBest(int a, int b) {
		double cur = Math.abs((double)x / y - (double)a / b);
		if (best - cur > 1e-15) {
			best = cur;
			bestNum = a;
			bestDen = b;
		}
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		x = in.nextInt();
		y = in.nextInt();
		int n = in.nextInt();
		
		bestNum = 0;
		bestDen = 0;
		best = Double.MAX_VALUE;
		for (int b = 1; b <= n; ++b) {
			long tmp = (long)b * x / y;
			int a = (int) tmp;
			updateBest(a, b);
			updateBest(a + 1, b);
		}
		
		int g = gcd(bestNum, bestDen);
		System.out.println((bestNum / g) + "/" + (bestDen / g));
		
		in.close();
		System.exit(0);
	}
}
