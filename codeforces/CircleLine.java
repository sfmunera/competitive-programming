package codeforces;

import java.io.*;
import java.util.*;

public class CircleLine {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		
		int[] d = new int[n];
		for (int i = 0; i < n; ++i)
			d[i] = in.nextInt();
		
		int s = in.nextInt() - 1;
		int t = in.nextInt() - 1;
		
		int totalSum = 0;
		for (int i = 0; i < n; ++i)
			totalSum += d[i];
		
		int sum = 0;
		for (int i = Math.min(s, t); i < Math.max(s, t); ++i)
			sum += d[i];
		
		System.out.println(Math.min(sum, totalSum - sum));
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
