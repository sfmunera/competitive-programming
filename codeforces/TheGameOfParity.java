package codeforces;

import java.io.*;
import java.util.*;

public class TheGameOfParity {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int odd = 0;
		int even = 0;
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			if (a % 2 == 0) {
				++even;
			} else {
				++odd;
			}
		}
		
		int m = n - k;
		
		if (m == 0) {
			System.out.println(odd % 2 == 1 ? "Stannis" : "Daenerys");
			return;
		}
		
		int Splays = (m + 1) / 2;
		int Dplays = m - Splays;
		if (odd <= Dplays) {
			System.out.println("Daenerys");
		} else {
			if (even <= Splays) {
				System.out.println(m % 2 == odd % 2 ? "Stannis" : "Daenerys");
			} else {
				System.out.println(m % 2 == 0 && odd % 2 == 1 ? "Daenerys" : "Stannis");
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
