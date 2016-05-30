package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LionAgeII {
	
	static String S;
	static int K;
	static int[][] value;
	static Integer[][][] dp;
	
	static int go(int k, int i, int prev) {
		if (i == S.length())
			return 0;
		
		if (dp[k][i][prev] != null)
			return dp[k][i][prev];
		
		int cur = S.charAt(i) - 'a';
		int ans = go(k, i + 1, cur) + (prev < 26 ? value[prev][cur] : 0);
		if (k > 0) {
			for (int c = 0; c < 26; ++c)
				if (c != cur)
					ans = Math.max(ans, go(k - 1, i + 1, c) + (prev < 26 ? value[prev][c] : 0));
		}
		
		return dp[k][i][prev] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		S = in.next();
		K = in.nextInt();
		int N = in.nextInt();
		
		value = new int[26][26];
		dp = new Integer[K + 1][S.length() + 1][28];
		
		for (int i = 0; i < N; ++i) {
			char c1 = in.next().charAt(0);
			char c2 = in.next().charAt(0);
			int cost = in.nextInt();
			
			value[c1 - 'a'][c2 - 'a'] = cost;
		}
		
		System.out.println(go(K, 0, 26));
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
