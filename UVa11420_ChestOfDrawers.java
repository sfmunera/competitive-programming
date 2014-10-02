package uva;

import java.io.*;
import java.util.*;

public class UVa11420_ChestOfDrawers {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int n = in.nextInt();
			int s = in.nextInt();
			
			if (n < 0 && s < 0)
				break;
			
			// (drawersLeft, securedLeft, previousLocked)
			long[][][] dp = new long[n + 1][s + 1][2];
			dp[0][0][0] = dp[0][0][1] = 1;
			for (int i = 1; i <= n; ++i)
				for (int j = 0; j <= s; ++j)
					for (int k = 0; k < 2; ++k) {
						dp[i][j][k] = dp[i - 1][j][0]; // unlock current
						if (j >= k)
							dp[i][j][k] += dp[i - 1][j - k][1]; // lock current, if previous was unlocked this is not secured
					}
			// Assume that the previous imaginary drawer before the first is locked
			sb.append(dp[n][s][1] + "\n");
		}
		System.out.print(sb);
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
