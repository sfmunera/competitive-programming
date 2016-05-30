package codeforces;

import java.io.*;
import java.util.*;

public class PrimesOnInterval {
	
	static boolean[] prime;
	
	static void sieve() {
		int N = 1000000;
		prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		for (int p = 2; p <= N / p; ++p)
			if (prime[p])
				for (int i = p * p; i <= N; i += p)
					prime[i] = false;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int k = in.nextInt();
		
		sieve();
		int[] freq = new int[b - a + 1];
		freq[0] = prime[a] ? 1 : 0;
		for (int i = 1; i < b - a + 1; ++i)
			freq[i] = freq[i - 1] + (prime[i] ? 1 : 0);

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
