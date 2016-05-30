package codeforces;

import java.io.*;
import java.util.*;

public class Football {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String players = in.next();
		
		boolean dangerous = false;
		for (int i = 0; i <= players.length() - 7; ++i) {
			boolean equal = true;
			for (int j = i + 1; j < i + 7; ++j) {
				if (players.charAt(j) != players.charAt(i)) {
					equal = false;
				}
			}
			if (equal) {
				dangerous = true;
			}
		}
		System.out.println(dangerous ? "YES" : "NO");
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
