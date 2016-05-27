package uva;

import java.io.*;
import java.util.*;

public class UVa10086_TestTheRods {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		while (true) {
			int T1 = in.nextInt();
			int T2 = in.nextInt();
			
			if (T1 == 0 && T2 == 0)
				break;
			
			int n = in.nextInt();
			int[][][] C = new int[n][][];
			int[] m = new int[n];
			
			for (int i = 0; i < n; ++i) {
				m[i] = in.nextInt();
				C[i] = new int[m[i] + 1][2];
				
				for (int k = 0; k < 2; ++k)
					for (int j = 1; j <= m[i]; ++j)
						C[i][j][k] = in.nextInt();
			}
			
			// currentIndex, T1Left
			int[][] dp = new int[n + 1][T1 + 1];
			// Optimal number of rods tested in state (currentIndex, T1Left)
			int[][] path = new int[n + 1][T1 + 1];
			
			for (int i = 0; i <= n; ++i) {
				Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
				Arrays.fill(path[i], -1);
			}

			dp[n][0] = 0;
			
			for (int i = n - 1; i >= 0; --i)
				for (int j = 0; j <= T1; ++j)
					for (int l = 0; l <= m[i] && j - l >= 0; ++l) {
						int x = dp[i + 1][j - l] + C[i][l][0] + C[i][m[i] - l][1];
						if (x < dp[i][j]) {
							dp[i][j] = x;
							path[i][j] = l;
						}
					}
			
			System.out.println(dp[0][T1]);
			int cur = T1;
			for (int i = 0; i < n; ++i) {
				if (i > 0) System.out.print(" ");
				System.out.print(path[i][cur]);
				cur -= path[i][cur];
			}
			System.out.println("\n");
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
