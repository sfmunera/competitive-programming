package codeforces;

import java.io.*;
import java.util.*;

public class LetsGoRolling {
	
	static Pair[] pairs;
	static Long[][] dp;
	static int N;
	
	static class Pair implements Comparable<Pair> {
		long x, c;
		public Pair(long x, long c) {
			this.x = x;
			this.c = c;
		}
		@Override
		public int compareTo(Pair p) {
			return this.x < p.x ? -1 : this.x > p.x ? 1 : 0;
		}
	}
	
	static long dp(int i, int prev) {
		if (i == N) return 0;
		
		if (dp[i][prev] != null)
			return dp[i][prev];
		
		return dp[i][prev] = Math.min(dp(i + 1, prev) + pairs[i].x - pairs[prev].x, 
									  dp(i + 1, i) + pairs[i].c);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		N = in.nextInt();
		pairs = new Pair[N];
		for (int i = 0; i < N; ++i) {
			long x = in.nextLong();
			long c = in.nextLong();
			
			pairs[i] = new Pair(x, c);
		}
		
		Arrays.sort(pairs);
		dp = new Long[N][N];
		
		System.out.println(dp(1, 0) + pairs[0].c);
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
