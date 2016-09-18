package uva;

import java.util.*;
import java.io.*;

public class UVa11000_Bee {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		long[] f = new long[101];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= 100; ++i)
			f[i] = f[i - 1] + f[i - 2] + 1;

		while (true) {
			int N = in.nextInt();
			if (N < 0)
				break;
			System.out.println(f[N] + " " + f[N + 1]);
		}
		
		System.exit(0);
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
