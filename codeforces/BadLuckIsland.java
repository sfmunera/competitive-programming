package codeforces;

import java.io.*;
import java.util.*;

public class BadLuckIsland {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int r = in.nextInt();
		int s = in.nextInt();
		int p = in.nextInt();
		
		
		double[][][] dp = new double[r + 1][s + 1][p + 1];
		dp[r][s][p] = 1.0;
		
		for (int i = r; i >= 0; --i) {
			for (int j = s; j >= 0; --j) {
				for (int k = p; k >= 0; --k) {
					int total = i * j + j * k + k * i;
					if (total == 0) continue;
					if (i > 0) dp[i - 1][j][k] += (double) k * i / total * dp[i][j][k];
					if (j > 0) dp[i][j - 1][k] += (double) i * j / total * dp[i][j][k];
					if (k > 0) dp[i][j][k - 1] += (double) j * k / total * dp[i][j][k];
				}
			}
		}
		double probRock = 0.0;
		double probScissor = 0.0;
		double probPaper = 0.0;
		for (int i = 1; i <= r; ++i) {
			probRock += dp[i][0][0];
		}
		for (int i = 1; i <= s; ++i) {
			probScissor += dp[0][i][0];
		}
		for (int i = 1; i <= p; ++i) {
			probPaper += dp[0][0][i];
		}
		
		System.out.println(probRock + " " + probScissor + " " + probPaper);
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
