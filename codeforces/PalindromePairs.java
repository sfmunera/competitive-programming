package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PalindromePairs {
	
	static String s;
	
	static Boolean[][] dpPal;
	static Integer[][] dp;
	
	static boolean isPalindrome(int l, int r) {
		if (l >= r)
			return true;
		
		if (dpPal[l][r] != null)
			return dpPal[l][r];
		
		return dpPal[l][r] = s.charAt(l) == s.charAt(r) && isPalindrome(l + 1, r - 1);
	}
	
	static int go(int l, int r) {
		if (l > r)
			return 0;
		if (l == r)
			return 1;
		
		if (dp[l][r] != null)
			return dp[l][r];
		
		return dp[l][r] = (isPalindrome(l, r) ? 1 : 0) + go(l + 1, r) + go(l, r - 1) - go(l + 1, r - 1);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		s = in.next();
		dpPal = new Boolean[s.length() + 1][s.length() + 1];
		dp = new Integer[s.length() + 1][s.length() + 1];
		
		long ans = 0;
		for (int i = 0; i < s.length(); ++i)
			for (int j = i; j < s.length(); ++j)
				if (i > 0 && isPalindrome(i, j))
					ans += go(0, i - 1);
		
		System.out.println(ans);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}
