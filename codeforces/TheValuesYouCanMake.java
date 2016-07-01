package codeforces;

import java.io.*;
import java.util.*;

public class TheValuesYouCanMake {
	
	/*static Boolean[][][] dp;
	
	static boolean go(int idx, int rem1, int rem2, int[] c) {
		if (idx < 0) return rem1 == 0 && rem2 == 0;
		if (rem1 < 0 || rem2 < 0) return false;
		
		if (dp[idx][rem1][rem2] != null) return dp[idx][rem1][rem2];
		
		boolean can = false;
		can |= go(idx - 1, rem1, rem2, c);
		can |= go(idx - 1, rem1 - c[idx], rem2, c);
		can |= go(idx - 1, rem1, rem2 - c[idx], c);
		
		return dp[idx][rem1][rem2] = can;
	}*/
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		
		for (int i = 0; i < n; ++i) {
			c[i] = in.nextInt();
		}
		
		boolean[][][] dp = new boolean[2][k + 1][k + 1];
		dp[0][0][0] = true;
		
		for (int i = 1; i <= c.length; ++i) {
			for (int j = 0; j <= k; ++j) {
				for (int m = 0; m <= k; ++m) {
					int cur = i % 2;
					int prev = 1 - cur;
					dp[cur][j][m]  = dp[prev][j][m];
					if (j >= c[i - 1])
						dp[cur][j][m] |= dp[prev][j - c[i - 1]][m];
					if (m >= c[i - 1])
						dp[cur][j][m] |= dp[prev][j][m - c[i - 1]];
				}
			}
		}
		
		List<Integer> ans = new ArrayList<Integer>();
		for (int x = 0; x <= k; ++x) {
			if (dp[c.length % 2][x][k - x]) {
				ans.add(x);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size() + "\n");
		for (int i = 0; i < ans.size(); ++i) {
			if (i > 0) sb.append(" ");
			sb.append(ans.get(i));
		}
		System.out.println(sb);
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
