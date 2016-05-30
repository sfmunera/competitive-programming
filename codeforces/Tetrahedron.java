package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetrahedron {
	
	static int mod = (int) 1e9 + 7;
	
	static long[][] multiply(long[][] a, long[][] b) {
		long[][] c = new long[4][4];
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				for (int k = 0; k < 4; ++k)
					c[i][j] = (c[i][j] + (a[i][k] * b[k][j]) % mod) % mod;
		
		return c;
	}
	
	static long[][] eye() {
		return new long[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
	}
	
	static long[][] fastPow(long[][] a, int n) {
		if (n == 0)
			return eye();
		if (n == 1)
			return a;
		if (n % 2 == 1)
			return multiply(a, fastPow(a, n - 1));
		else {
			long[][] tmp = fastPow(a, n / 2);
			return multiply(tmp, tmp);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();

		long[][] dp = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};
		
		long[][] ans = fastPow(dp, n);
		System.out.println(ans[0][0]);
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
