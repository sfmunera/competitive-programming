package codeforces;

import java.io.*;
import java.util.*;

public class TwoSubstrings {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String s = in.next();
		
		int N = s.length();

		int firstAB = -1;
		int firstBA = -1;
		int lastAB = -1;
		int lastBA = -1;
		for (int i = 0; i < N - 1; ++i) {
			if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'B') {
				if (firstAB < 0) {
					firstAB = i;
				}
				lastAB = i;
			}
			if (s.charAt(i) == 'B' && s.charAt(i + 1) == 'A') {
				if (firstBA < 0) {
					firstBA = i;
				}
				lastBA = i;
			}
		}
		
		boolean yes = false;
		if (firstAB >= 0 && firstBA >= 0 && (Math.abs(firstAB - lastBA) > 1 || Math.abs(firstBA - lastAB) > 1)) {
			yes = true;
		}
		
		System.out.println(yes ? "YES" : "NO");
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
