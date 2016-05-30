package codeforces;

import java.io.*;
import java.util.*;

public class LittleGirlAndGame {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		char[] s = in.next().toCharArray();
		int[] freq = new int[26];
		
		for (char c : s)
			++freq[c - 'a'];
		
		int cnt = 0;
		for (int i = 0; i < 26; ++i)
			if (freq[i] % 2 == 1)
				++cnt;
		
		if (cnt <= 1 || cnt % 2 == 1)
			System.out.println("First");
		else
			System.out.println("Second");
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
