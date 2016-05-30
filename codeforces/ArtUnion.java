package codeforces;

import java.util.*;

public class ArtUnion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int m = in.nextInt();
		int n = in.nextInt();
		
		int[][] dp = new int[m + 1][n + 1]; // first row = first col = 0
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				dp[i][j] = in.nextInt();
				// max(previous painting time, previous painter time)
				dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= m; ++i) {
			if (i > 1) sb.append(" ");
			sb.append(dp[i][n]);
		}
		System.out.println(sb);
		
		in.close();
		System.exit(0);
	}
}
