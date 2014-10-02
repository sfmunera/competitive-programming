package uva;

import java.io.*;
import java.util.*;

public class UVa10910_MarksDistribution {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int K = in.nextInt();
		while (K-- > 0) {
			int N = in.nextInt();
			int T = in.nextInt();
			int P = in.nextInt();
			
			int[][] dp = new int[N + 1][T + 1];
			dp[0][0] = 1;
			for (int i = 1; i <= N; ++i) // subjects
				for (int j = 0; j <= T; ++j) // grades
					for (int k = P; k <= j && j - k >= (i - 1) * P; ++k) // grade for next subject
						dp[i][j] += dp[i - 1][j - k];

			System.out.println(dp[N][T]);
		}
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
