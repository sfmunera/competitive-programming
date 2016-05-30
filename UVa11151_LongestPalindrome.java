package uva;

import java.io.*;

public class UVa11151_LongestPalindrome {

	static String str;
	static boolean[][] seen;
	static int[][] dp;
	
	static int go(int l, int r) {
		if (l > r) return 0;
		if (l == r) return 1;
		if (l + 1 == r) return str.charAt(l) == str.charAt(r) ? 2 : 1;
		
		if (seen[l][r]) return dp[l][r];
		seen[l][r] = true;
		
		if (str.charAt(l) == str.charAt(r))
			dp[l][r] = 2 + go(l + 1, r - 1);
		dp[l][r] = Math.max(dp[l][r], Math.max(go(l + 1, r), go(l, r - 1)));
		return dp[l][r];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0 ) {
			str = in.readLine();
			int N = str.length();
			
			seen = new boolean[N + 5][N + 5];
			dp = new int[N + 5][N + 5];
			System.out.println(go(0, N - 1));
		}
		
		in.close();
		System.exit(0);
	}
}
