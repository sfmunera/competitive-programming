package codeforces;

import java.io.*;
import java.util.*;

public class KitaharaHarukisGift {
	
	static int[] w;
	static int n;
	static Boolean[][] dp;
	
	static boolean possible(int i, int weightLeft) {
		if (weightLeft < 0)
			return false;
		if (weightLeft == 0)
			return true;
		if (i == n && weightLeft != 0)
			return false;
		
		if (dp[i][weightLeft] != null)
			return dp[i][weightLeft];

		return dp[i][weightLeft] = possible(i + 1, weightLeft) || possible(i + 1, weightLeft - w[i]);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		w = new int[n];
		
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			w[i] = in.nextInt() / 100;
			sum += w[i];
		}
		
		boolean possible = false;
		if (sum % 2 == 0) {
			dp = new Boolean[n + 1][sum / 2 + 1];
			possible = possible(0, sum / 2);
		}
		
		System.out.println(possible ? "YES" : "NO");
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
