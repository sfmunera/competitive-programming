package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChillyWilly {
	
	static void printNumber(int n, int i, int j) {
		StringBuilder ans = new StringBuilder();
		ans.append("1");
		for (int k = 0; k < n - 4; ++k)
			ans.append("0");
		ans.append(j);
		ans.append(i);
		ans.append("0");
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		
		if (n < 3)
			System.out.println(-1);
		else if (n == 3)
			System.out.println(210);
		else {
			int[] pattern = {1, 3, 2, -1, -3, -2};
			boolean done = false;
			for (int j = 0; j < 10 && !done; ++j)
				for (int i = 0; i < 10 && !done; ++i) {
					if ((i + j + 1) % 3 == 0 && Math.abs(pattern[(n - 1) % 6] + i * 3 + j * 2) % 7 == 0) {
						done = true;
						printNumber(n, i, j);
					}
				}
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
