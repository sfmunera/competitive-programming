package uva;

import java.util.*;
import java.io.*;

public class UVa10721_BarCodes {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			long[][] dp = new long[n + 1][k + 1];

			dp[0][0] = 1;
			for (int i = 1; i <= n; ++i) // units
				for (int j = 1; j <= k; ++j) // bars
					for (int l = 1; l <= m && l <= i; ++l) // size of the next bar
						dp[i][j] += dp[i - l][j - 1];
			
			System.out.println(dp[n][k]);
		}
		
		in.close();
		System.exit(0);
	}
}
