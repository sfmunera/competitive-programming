package spoj;

import java.io.*;
import java.util.*;

public class ROCK {
	
	static String bar;
	static int[][] dp;
	
	static int go(int l, int r) {
		if (l > r) return 0;
		if (l == r) return bar.charAt(l) == '1' ? 1 : 0;
		
		if (dp[l][r] != -1)
			return dp[l][r];
		
		int sweet = 0;
		for (int i = l; i <= r; ++i)
			if (bar.charAt(i) == '1')
				++sweet;
		int sour = r - l + 1 - sweet;
		
		if (sweet > sour)
			return dp[l][r] = r - l + 1;
		
		int len = 0;
		for (int i = l; i < r; ++i)
			len = Math.max(len, go(l, i) + go(i + 1, r));
		return dp[l][r] = len;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int MAXN = 205;
		dp = new int[MAXN][MAXN];
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			bar = in.readLine();
			
			for (int i = 0; i < MAXN; ++i)
				Arrays.fill(dp[i], -1);
			
			System.out.println(go(0, N - 1));
		}
	}
}
