package codeforces;

import java.util.*;
import java.io.*;

public class CutRibbon {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		
		int[] cuts = new int[]{a, b, c};
		
		int[] dp = new int[n + 1]; // max value, remaining i elements
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; ++i)
			for (int j = 0; j < 3; ++j)
				if (i - cuts[j] >= 0)
					dp[i] = Math.max(dp[i], 1 + dp[i - cuts[j]]);
		
		System.out.println(dp[n]);
		
		in.close();
		System.exit(0);
	}
}
