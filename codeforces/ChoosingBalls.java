package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChoosingBalls {
	
	static Long[][] dp, dp2;
	static long[] c, v;
	static long a, b;
	static int n;
	static final long INF = (long) 1e9;
	
	/*static long go(int index, int prev) {
		if (index == n)
			return 0;
		
		if (dp[index][prev] != null)
			return dp[index][prev];
		
		long ans1 = go(index + 1, prev);
		long ans2 = go(index + 1, index) + v[index] * (prev < n && c[prev] == c[index] ? a : b);
		
		return dp[index][prev] = Math.max(ans1, ans2);
	}*/
	
	
	
	// <current position, same color as previous?>
	static long go2(int index, boolean same) {
		if (index == n)
			return 0;
		
		if (dp2[index][same ? 1 : 0] != null)
			return dp2[index][same ? 1 : 0];
		
		long ans1 = go2(index + 1, c[index + 1] == c[index] && same);
		long ans2 = go2(index + 1, c[index + 1] == c[index]) + v[index] * (same ? a : b);
		
		return dp2[index][same ? 1 : 0] = Math.max(ans1, ans2);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		n = in.nextInt();
		int q = in.nextInt();
		v = new long[n];
		c = new long[n + 1];
		
		for (int i = 0; i < n; ++i)
			v[i] = in.nextLong();
		for (int i = 0; i < n; ++i)
			c[i] = in.nextLong();
		
		for (int i = 0; i < q; ++i) {
			a = in.nextLong();
			b = in.nextLong();
			
			dp2 = new Long[n + 2][2];
			System.out.println(go2(0, false));
		}
		
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
