package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YaroslavAndPermutation {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int N = in.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; ++i)
			numbers[i] = in.nextInt();
		
		Arrays.sort(numbers);
		int cnt = 1;
		boolean ok = true;
		for (int i = 1; i < N && ok; ++i) {
			if (numbers[i] != numbers[i - 1]) {
				if (cnt > (N + 1) / 2)
					ok = false;
				cnt = 0;
			}
			++cnt;
		}
		if (cnt > (N + 1) / 2)
			ok = false;
		System.out.println(ok ? "YES" : "NO");
		
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
