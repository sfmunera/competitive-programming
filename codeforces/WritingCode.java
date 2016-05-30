package codeforces;

import java.io.*;
import java.util.*;

public class WritingCode {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int b = in.nextInt();
		int mod = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		int[][] dpPrev = new int[m + 1][b + 1];
		int[][] dp = new int[m + 1][b + 1];
		for (int k = 0; k <= b; ++k) {
			dpPrev[0][k] = 1;
		}
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				for (int k = 0; k <= b; ++k) {
					dp[j][k] = dpPrev[j][k];
					dp[j][k] %= mod;
					if (j > 0 && k >= a[i - 1]) {
						dp[j][k] += dp[j - 1][k - a[i - 1]];
						dp[j][k] %= mod;
					}
					dpPrev[j][k] = dp[j][k];
				}
			}
		}

		System.out.println(dp[m][b]);
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
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
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}
