package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RelayRace {
	
	static int doDp(int[][] mat, int N) {
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				dp[i][j] = mat[i][j];
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j) {
				if (i > 0)
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + mat[i][j]);
				if (j > 0)
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + mat[i][j]);
			}
		
		boolean done = false;
		for (int i = N - 1; i >= 0 && !done; )
			for (int j = N - 1; j >= 0 && !done; ) {
				mat[i][j] = 0;
				if (i == 0 && j == 0)
					done = true;
				if (i > 0 && j > 0) {
					if (dp[i - 1][j] > dp[i][j - 1])
						--i;
					else
						--j;
				} else if (i > 0)
					--i;
				else if (j > 0)
					--j;
			}
		
		return dp[N - 1][N - 1];
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int[][] mat = new int[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				mat[i][j] = in.nextInt();
		
		int ans = doDp(mat, N);
		ans += doDp(mat, N);
		System.out.println(ans);
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
