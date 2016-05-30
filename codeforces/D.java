package codeforces;

import java.io.*;
import java.util.*;

public class D {

	static boolean can(long m, long k, long[] c) {		
		for (int i = 0; i < c.length / 2; ++i) {
			long d = c[c.length - 1 - i] - c[i];
			if (d > m) {
				long diff = (d - m) / 2;
				k -= diff;
				if (k < 0) return false;
			}
		}
		
		return true;
	}
	
	static void solve(int n, long k, long[] c) {
		Arrays.sort(c);
		long low = 0;
		long high = c[n - 1] - c[0];
		
		long ans = 0;
		while (low <= high) {
			long mid = (low + high) / 2;
			if (can(mid, k, c)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
				
			}
 		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		long k = in.nextLong();
		
		long[] c = new long[n];
		for (int i = 0; i < n; ++i) {
			c[i] = in.nextLong();
		}
		
		solve(n, k, c);
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
