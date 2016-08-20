package codeforces;

import java.io.*;
import java.util.*;

public class PythagoreanTriples {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		long n = in.nextLong();
		if (n <= 2) System.out.println(-1);
		else {
			if (n % 2 == 0) {
				long x = (n * n - 4L) / 4L;
				long y = x + 2;
				
				System.out.println(x + " " + y);
			} else {
				long x = (n * n - 1L) / 2L;
				long y = x + 1;
				
				System.out.println(x + " " + y);
			}
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
