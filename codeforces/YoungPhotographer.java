package codeforces;

import java.io.*;
import java.util.*;

public class YoungPhotographer {
	
	static final int MAX = 1000;
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int x0 = in.nextInt();
		
		int[] count = new int[MAX + 1];
		
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			for (int j = Math.min(a, b); j <= Math.max(a, b); ++j) {
				++count[j];
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= MAX; ++i) {
			if (count[i] == n) {
				ans = Math.min(ans, Math.abs(x0 - i));
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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
