package codeforces;

import java.io.*;
import java.util.*;

public class RemaindersGame {
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		
		for (int i = 0; i < n; ++i) {
			c[i] = in.nextInt();
		}
		
		long lcm = 1;
		for (int i = 0; i < n; ++i) {
			lcm = lcm(lcm, c[i]);
			lcm %= k;
		}
		
		System.out.println(lcm == 0 ? "Yes" : "No");
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
