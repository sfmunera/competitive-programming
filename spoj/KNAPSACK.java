package spoj;

import java.io.*;
import java.util.*;

public class KNAPSACK {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int S = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		
		int[] s = new int[N + 1];
		int[] v = new int[N + 1];
		
		for (int i = 1; i <= N; ++i) {
			stk = new StringTokenizer(in.readLine());
			s[i] = Integer.parseInt(stk.nextToken());
			v[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[][] dp = new int[S + 1][N + 1];
		for (int i = 0; i <= S; ++i)
			for (int j = 1; j <= N; ++j) {
				dp[i][j] = dp[i][j - 1];
				if (i - s[j] >= 0)
					dp[i][j] = Math.max(dp[i][j], v[j] + dp[i - s[j]][j - 1]);
			}
		System.out.println(dp[S][N]);
	}
}
