package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CaesarsLegions {
	
	static final int mod = (int) 1e8;
	static int K1, K2, N1, N2;
	
	static Integer[][][][][] dp;
	
	static int go(int n1, int n2, int k1, int k2, int prevN1) {
		if (n1 == 0 && n2 == 0)
			return 1;
		
		if (dp[n1][n2][k1][k2][prevN1] != null)
			return dp[n1][n2][k1][k2][prevN1];
		
		int ans = 0;
		if (n1 > 0)
			if (prevN1 == 1) {
				if (k1 < K1) {
					ans += go(n1 - 1, n2, k1 + 1, 0, 1);
					ans %= mod;
				}
			} else {
				ans += go(n1 - 1, n2, 1, 0, 1);
				ans %= mod;
			}
		
		if (n2 > 0)
			if (prevN1 == 0) {
				if (k2 < K2) {
					ans += go(n1, n2 - 1, 0, k2 + 1, 0);
					ans %= mod;
				}
			} else {
				ans += go(n1, n2 - 1, 0, 1, 0);
				ans %= mod;
			}
		
		return dp[n1][n2][k1][k2][prevN1] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		N1 = in.nextInt();
		N2 = in.nextInt();
		K1 = in.nextInt();
		K2 = in.nextInt();
		
		dp = new Integer[N1 + 1][N2 + 1][K1 + 1][K2 + 1][3];
		
		System.out.println(go(N1, N2, 0, 0, 2));
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
