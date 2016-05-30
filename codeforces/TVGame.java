package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TVGame {
	
	static String A;
	static int n;
	static Long[][] dp;

	static long go(int n1, int n2) {
		if (n1 == 0 && n2 == 0)
			return 0;

		if (dp[n1][n2] != null)
			return dp[n1][n2];
			
		int d = A.charAt(2 * n - n1 - n2) - '0';
		
		long ans1 = 0, ans2 = 0;
		if (n1 > 0)
			ans1 = go(n1 - 1, n2) + Math.round(Math.pow(10, n1 - 1)) * d;
		if (n2 > 0)
			ans2 = go(n1, n2 - 1) + Math.round(Math.pow(10, n2 - 1)) * d;
		
		return dp[n1][n2] = Math.max(ans1, ans2);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		n = in.nextInt();
		A = in.next();
		
		dp = new Long[n + 1][n + 1];
		
		go(n, n);
		String path = "";
		for (int n1 = n, n2 = n; n1 > 0 || n2 > 0; ) {
			int d = A.charAt(2 * n - n1 - n2) - '0';
			if (n1 > 0 && dp[n1][n2] == dp[n1 - 1][n2] + Math.round(Math.pow(10L, n1 - 1)) * d) {
				path += "H";
				--n1;
			} else {
				path += "M";
				--n2;
			}
		}
		System.out.println(path);
		
		System.exit(0);
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
