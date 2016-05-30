package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Haiku {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		boolean isHaiku = true;
		int[] syllable = {5, 7, 5};
		for (int i = 0; i < 3; ++i) {
			String phrase = in.nextLine();
			int cnt = 0;
			for (int j = 0; j < phrase.length(); ++j)
				if (phrase.charAt(j) == 'a' || phrase.charAt(j) == 'e' || phrase.charAt(j) == 'i' ||
					phrase.charAt(j) == 'o' || phrase.charAt(j) == 'u')
					++cnt;
			if (cnt != syllable[i])
				isHaiku = false;
		}
		
		System.out.println(isHaiku ? "YES" : "NO");
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
