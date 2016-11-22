package codeforces;

import java.util.*;

public class ColoringTrees {
	
	static final long INF = Long.MAX_VALUE / 3;
	static int N, M, K;
	static long[][] p;
	static int[] trees;
	static Long[][][] dp;
	
	static long solve(int index, int prev, int k) { // coloring tree 'index'
		if (index == N) {
			if (k == K) {
				return 0;
			} else {
				return INF;
			}
		}
		
		if (dp[index][prev][k] != null) {
			return dp[index][prev][k];
		}
		
		long ans = INF;
		if (trees[index] == 0) {
			for (int c = 1; c <= M; c++) {
				if (c == prev) {
					ans = Math.min(ans, p[index][c] + solve(index + 1, c, k));
				} else {
					if (k + 1 <= K)
						ans = Math.min(ans, p[index][c] + solve(index + 1, c, k + 1));
				}
			}
		} else {
			if (k + (prev != trees[index] ? 1 : 0) <= K)
				ans = Math.min(ans, solve(index + 1, trees[index], k + (prev != trees[index] ? 1 : 0)));
		}
		
		return dp[index][prev][k] = ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		
		dp = new Long[N + 5][M + 5][K + 5];
		
		trees = new int[N];
		for (int i = 0; i < N; i++) {
			trees[i] = in.nextInt();
		}
		p = new long[N][M + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= M; j++) {
				p[i][j] = in.nextLong();
			}
		}
		
		long ans = solve(0, 0, 0);
		System.out.println(ans == INF ? -1 : ans);
		
		in.close();
		System.exit(0);
	}
}
