package codeforces;

import java.io.*;
import java.util.*;

public class TheMathsLecture {
	
	static int dp(int digit, int mod, boolean isZero, int n, int k, int m, int[] pow10, Integer[][][] dp) {
		if (digit == n) {
			return mod == 0 && !isZero ? 1 : 0;
		}
		if (dp[digit][mod][isZero ? 1 : 0] != null) {
			return dp[digit][mod][isZero ? 1 : 0];
		}
		
		int ans = 0;
		for (int d = (digit == n - 1 ? 1 : 0); d < 10; ++d) {
			int newMod = (!isZero && mod == 0) ? 0 : (mod + d * pow10[digit]) % k;
			ans += dp(digit + 1, newMod, isZero && d == 0, n, k, m, pow10, dp) % m;
			ans %= m;
		}
		return dp[digit][mod][isZero ? 1 : 0] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();
		
		int[] pow10 = new int[n];
		pow10[0] = 1;
		for (int i = 1; i < n; ++i) {
			pow10[i] = (10 * pow10[i - 1]) % k;
		}
		
		Integer[][][] dp = new Integer[n + 1][k + 1][2];
		int ans = dp(0, 0, true, n, k, m, pow10, dp);
		
		System.out.println(ans);
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
