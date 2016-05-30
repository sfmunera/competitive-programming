package codeforces;

import java.io.*;
import java.util.*;

public class MikeAndFax {
	
	static boolean isPalindrome(String s, int left, int right) {
		for (int l = left, r = right; l < r; ++l, --r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String s = in.next();
		int k = in.nextInt();
		
		int n = s.length();
		boolean yes = true;
		if (n % k != 0) {
			yes = false;
		} else {
			int m = n / k;
			for (int i = 0; i < n; i += m) {
				if (!isPalindrome(s, i, i + m - 1)) {
					yes = false;
				}
			}
		}
		
		System.out.println(yes ? "YES" : "NO");
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
