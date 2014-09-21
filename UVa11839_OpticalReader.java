package uva;

import java.util.*;
import java.io.*;

public class UVa11839_OpticalReader {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		while (true) {
			int N = in.nextInt();
			if (N == 0)
				break;
			for (int i = 0; i < N; ++i) {
				boolean[] marked = new boolean[5];
				int cnt = 0;
				int ans = 0;
				for (int j = 0; j < 5; ++j) {
					marked[j] = in.nextInt() <= 127;
					if (marked[j]) {
						++cnt;
						ans = j;
					}
				}
				if (cnt == 1)
					System.out.println((char) (ans + 'A'));
				else
					System.out.println("*");
			}
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
