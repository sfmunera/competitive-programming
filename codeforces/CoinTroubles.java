package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinTroubles {
	
	static final int MOD = (int) (1e9 + 7);
	static int[] types;
	static Integer[][] dp;
	static boolean[][] greater;
	
	static int solve(int index, int t) {
		if (t < 0) {
			return 0;
		}
		if (index == types.length) {
			return t == 0 ? 1 : 0;
		}
		
		if (dp[index][t] != null) {
			return dp[index][t];
		}
		
		int ans = 0;
		ans += solve(index + 1, t);
		ans %= MOD;
		ans += solve(index, t - types[index]);
		ans %= MOD;
		
		return dp[index][t] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int q = in.nextInt();
		int t = in.nextInt();
		
		types = new int[n];
		for (int i = 0; i < n; ++i)
			types[i] = in.nextInt();
		
		greater = new boolean[n][n];
		
		dp = new Integer[n + 1][t + 1];
		
		for (int i = 0; i < q; ++i) {
			int b = in.nextInt() - 1;
			int c = in.nextInt() - 1;
			
			greater[b][c] = true;
		}
		System.out.println(solve(0, t));
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
