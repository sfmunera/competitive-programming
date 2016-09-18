package uva;

import java.util.*;
import java.io.*;

public class UVa11258_StringPartition {
	
	static String number;
	static long[][] dp;
	
	static long go(int l, int r) {
		if (l > r) return 0;
		
		if (dp[l][r] != -1) return dp[l][r];
		
		long ans = 0;
		for (int i = l + 1; i <= r + 1; ++i) {
			String str = number.substring(l, i);
			if (str.length() > 1 && str.charAt(0) == '0') continue;
			
			long num = Long.parseLong(str);
			if (num >= Integer.MAX_VALUE) break;
			
			ans = Math.max(ans, num + go(i, r));
		}
		
		return dp[l][r] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			number = in.readLine();
			int n = number.length();

			dp = new long[n + 1][n + 1];
			for (int i = 0; i <= n; ++i)
				Arrays.fill(dp[i], -1);
			
			System.out.println(go(0, n - 1));
		}
		
		in.close();
		System.exit(0);
	}
}
