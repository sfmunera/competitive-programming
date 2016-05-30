package uva;

import java.util.*;
import java.io.*;

public class UVa10911_FormingQuizTeams {
	
	static int N;
	static int[] x, y;
	static boolean[] seen;
	static double[] dp;
	
	static double dist(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	static double go(int mask) {
		if (mask == (1 << N) - 1) return 0.0;
		
		if (seen[mask]) return dp[mask];
		seen[mask] = true;
		
		int s = 0;
		for (int i = 0; i < N; ++i)
			if ((mask & (1 << i)) == 0) {
				s = i;
				break;
			}
		double ans = Double.MAX_VALUE;
		for (int i = s + 1; i < N; ++i)
			if ((mask & (1 << i)) == 0)
				ans = Math.min(ans, dist(x[s], y[s], x[i], y[i]) + go(mask | (1 << s) | (1 << i)));
		
		return dp[mask] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			N = 2 * Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			x = new int[N];
			y = new int[N];
			
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				stk.nextToken();
				x[i] = Integer.parseInt(stk.nextToken());
				y[i] = Integer.parseInt(stk.nextToken());
			}
			
			seen = new boolean[1 << N];
			dp = new double[1 << N];
			
			double ans = go(0);
			System.out.printf(Locale.ENGLISH, "Case %d: %.2f\n", t++, ans);
		}
		
		in.close();
		System.exit(0);
	}
}
