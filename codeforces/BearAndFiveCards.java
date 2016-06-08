package codeforces;

import java.io.*;
import java.util.*;

public class BearAndFiveCards {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int[] t = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; ++i) {
			t[i] = in.nextInt();
			sum += t[i];
		}
		
		Arrays.sort(t);
		
		int min = sum;
		for (int i = 0; i + 1 < 5; ++i) {
			if (t[i] == t[i + 1]) {
				min = Math.min(min, sum - 2 * t[i]);
			}
		}
		for (int i = 0; i + 2 < 5; ++i) {
			if (t[i] == t[i + 1] && t[i + 1] == t[i + 2]) {
				min = Math.min(min, sum - 3 * t[i]);
			}
		}
		
		System.out.println(min);
		
		System.exit(0);
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
