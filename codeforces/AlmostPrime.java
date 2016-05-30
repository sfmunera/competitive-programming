package codeforces;

import java.io.*;
import java.util.*;

public class AlmostPrime {
	
	static boolean isAlmostPrime(int x) {
		int cnt = 0;
		for (int p = 2; p <= x / p; ++p)
			if (x % p == 0) {
				++cnt;
				while (x % p == 0)
					x /= p;
			}
		if (x > 1)
			++cnt;
		
		return cnt == 2;
	}
	
	public static void main(String[] args) {
		
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int cnt = 0;
		for (int x = 1; x <= N; ++x)
			if (isAlmostPrime(x))
				++cnt;
		
		System.out.println(cnt);
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
