package uva;

import java.util.*;
import java.io.*;

public class UVa10066_TheTwinTowers {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int t = 1;
		while (true) {
			int M = in.nextInt();
			int N = in.nextInt();
			if (M == 0 && N == 0)
				break;
			
			int[] X = new int[M];
			int[] Y = new int[N];
			for (int i = 0; i < M; ++i)
				X[i] = in.nextInt();
			for (int j = 0; j < N; ++j)
				Y[j] = in.nextInt();
			
			int[][] dp = new int[M + 1][N + 1];
			for (int i = 0; i <= M; ++i)
				dp[i][0] = 0;
			for (int j = 0; j <= N; ++j)
				dp[0][j] = 0;
			
			for (int i = 1; i <= M; ++i)
				for (int j = 1; j <= N; ++j)
					if (X[i - 1] == Y[j - 1])
						dp[i][j] = 1 + dp[i - 1][j - 1];
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			System.out.println("Twin Towers #" + t++);
			System.out.println("Number of Tiles : " + dp[M][N]);
			System.out.println();
		}
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
