package codeforces;

import java.io.*;
import java.util.*;

public class LinelandMail {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] cities = new int[n];
		
		for (int i = 0; i < n; ++i) {
			cities[i] = in.nextInt();
		}
		
		for (int i = 0; i < n; ++i) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			if (i > 0) {
				min = Math.min(min, cities[i] - cities[i - 1]);
				max = Math.max(max, cities[i] - cities[0]);
			}
			if (i < n - 1) {
				min = Math.min(min, cities[i + 1] - cities[i]);
				max = Math.max(max, cities[n - 1] - cities[i]);
			}
			
			System.out.println(min + " " + max);
		}
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
