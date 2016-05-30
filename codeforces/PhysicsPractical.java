package codeforces;

import java.io.*;
import java.util.*;

public class PhysicsPractical {
	
	static int n;
	static int[] c;
	static Integer[][] dp;
	
	static int go(int l, int r) {
		if (l >= r)
			return Integer.MAX_VALUE;
		if (c[r] <= 2 * c[l])
			return n - (r - l + 1);
		
		if (dp[l][r] != null)
			return dp[l][r];
		
		return dp[l][r] = Math.min(go(l + 1, r),  go(l, r - 1)); 
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		c = new int[n];
		
		for (int i = 0; i < n; ++i)
			c[i] = in.nextInt();
		
		Arrays.sort(c);
		dp = new Integer[n][n];
		
		System.out.println(go(0, n - 1));
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
