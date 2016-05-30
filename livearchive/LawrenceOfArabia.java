package livearchive;

import java.util.*;
import java.io.*;

public class LawrenceOfArabia {

	// f(i, a) -> min strategic value from [0, i], with a attacks (0 <= i < n, 0 <= a <= m)
	// f(i, a) = min_{0 <= j < i} {f(j, a-1) + value(j+1, i)}
	// f(0, a) = 0
	// f(i, 0) = value(0, i)
	static int doDp(int n, int m, int[][] value) {
		int[][] dp = new int[n][m + 1];
		for (int a = 0; a <= m; ++a) dp[0][a] = 0;
		for (int i = 0; i < n; ++i) dp[i][0] = value[0][i];
		
		for (int i = 1; i < n; ++i) {
			for (int a = 1; a <= m; ++a) {
				dp[i][a] = Integer.MAX_VALUE;
				for (int j = 0; j < i; ++j) {
					dp[i][a] = Math.min(dp[i][a], dp[j][a - 1] + value[j + 1][i]);
				}
			}
		}
		
		return dp[n - 1][m];
	}
	
	// values(i, i) = 0
	// values(i, j) = values(i, j - 1) + sum(i, j - 1) * depots[j]; j > i
	static int[][] calcValues(int[] depots) {
		int n = depots.length;
		int[][] value = new int[n][n];
		int[] sum = new int[n];
		
		for (int i = 0; i < n; ++i) {
			sum[i] = depots[i] + (i > 0 ? sum[i - 1] : 0);
			value[i][i] = 0;
		}
		
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				value[i][j] = value[i][j - 1] + depots[j] * (sum[j - 1] - (i > 0 ? sum[i - 1] : 0));
			}
		}
		
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			stk = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			if (n == 0 && m == 0) break;
			
			stk = new StringTokenizer(in.readLine());
			int[] depots = new int[n];
			for (int i = 0; i < n; ++i) {
				depots[i] = Integer.parseInt(stk.nextToken());
			}

			sb.append(doDp(n, m, calcValues(depots)));
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		in.close();
		System.exit(0);
	}
}
