package codeforces;

import java.io.*;
import java.util.*;

public class HardProblem {
	
	static final long INF = (long) 1e15; 
	
	static int n;
	static long[] cost;
	static String[] strings, reversed;
	
	static Long[][] dp;
	
	static long solve(int index, boolean prevReversed) {
		if (index == n) {
			return 0;
		}
		
		if (dp[index][prevReversed ? 1 : 0] != null) {
			return dp[index][prevReversed ? 1 : 0];
		}
		
		long ans = INF;
		if (index == 0 || lessThan(prevReversed ? reversed[index - 1] : strings[index - 1], strings[index])) {
			ans = Math.min(ans, solve(index + 1, false));
		}
		
		if (index == 0 || lessThan(prevReversed ? reversed[index - 1] : strings[index - 1], reversed[index])) {
			ans = Math.min(ans, cost[index] + solve(index + 1, true));
		}
		
		return dp[index][prevReversed ? 1 : 0] = ans;
	}
	
	static boolean lessThan(String A, String B) {
		if (A.length() < B.length() && B.startsWith(A)) {
			return true;
		}
		
		for (int i = 0; i < Math.min(A.length(), B.length()); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				return A.charAt(i) < B.charAt(i);
			}
		}
		
		return A.length() == B.length();
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		cost = new long[n];
		for (int i = 0; i < n; i++) {
			cost[i] = in.nextLong();
		}
		
		strings = new String[n];
		reversed = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = in.next();
			reversed[i] = new StringBuilder(strings[i]).reverse().toString();
		}
		
		dp = new Long[n + 1][2];
		long ans = solve(0, false);
		System.out.println(ans >= INF ? -1 : ans);
		
		System.exit(0);
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
