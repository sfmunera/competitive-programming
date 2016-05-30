package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiplicationTable {
	
	static String toBase(int x, int base) {
		String ans = "";
		while (x > 0) {
			ans = (x % base) + ans;
			x /= base;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int k = in.nextInt();
		
		for (int i = 1; i < k; ++i) {
			for (int j = 1; j < k; ++j) {
				if (j > 1)
					System.out.print(" ");
				System.out.print(toBase(i * j, k));
			}
			System.out.println();
		}
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
