package codeforces;

import java.io.*;
import java.util.*;

public class SoldierAndNumberGame {
	
	static final int MAX = 5000001;
	static List<Integer> primes;
	
	static int[] sieve() {
		int[] smallestPrime = new int[MAX];
		for (int i = 0; i < MAX; ++i) {
			smallestPrime[i] = i;
		}
		smallestPrime[0] = smallestPrime[1] = 1;
		
		for (int i = 2; i * i < MAX; ++i) {
			if (smallestPrime[i] == i) {
				for (int j = i * i; j < MAX; j += i) {
					if (smallestPrime[j] == j) {
						smallestPrime[j] = i;
					}
				}
			}
		}
		return smallestPrime;
	}
	
	static long[] accumPrimeFactors() {
		int[] smallestPrime = sieve();

		long[] numFactors = new long[MAX];
		
		for (int i = 2; i < MAX; ++i) {
			numFactors[i] = 1 + (smallestPrime[i] == 0 ? 0 : numFactors[i / smallestPrime[i]]);
		}
		
		for (int i = 1; i < MAX; ++i) {
			numFactors[i] += numFactors[i - 1];
		}
		
		return numFactors;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);		
		long[] numFactors = accumPrimeFactors();
		
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		for (int i = 0; i < t; ++i) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			long ans = numFactors[a] - numFactors[b];
			
			sb.append(ans);
			sb.append("\n");
		}
		System.out.print(sb);
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
