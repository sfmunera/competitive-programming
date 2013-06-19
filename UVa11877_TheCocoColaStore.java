package uva;

import java.util.*;
import java.io.*;

public class UVa11877_TheCocoColaStore {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;

			int ans = 0;
			while (n > 1) {
				int d = n / 3;
				int r = n % 3;
				ans += d;
				n = d + r;
				if (n == 2)
					++n;
			}
			System.out.println(ans);
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
