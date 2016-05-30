package uva;

import java.util.*;
import java.io.*;

public class UVa11408_CountDePrimes {

	static boolean[] prime;
	static int[] sumPrimes;

	static void sieve(int N) {
		prime = new boolean[N + 1];
		sumPrimes = new int[N + 1];

		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int p = 2; p * p <= N; ++p)
			if (prime[p])
				for (int i = 2 * p; i <= N; i += p) {
					prime[i] = false;
					sumPrimes[i] += p;
				}
		for (int p = 2; p <= N; ++p)
			if (prime[p]) {
				sumPrimes[p] = p;
				if (p > N / p)
					for (int i = 2 * p; i <= N; i += p) {
						prime[i] = false;
						sumPrimes[i] += p;
					}
			}
	}
	
	public static void main(String[] args) {
		sieve(5000000);
		int[] f = new int[5000001];

		for (int i = 2; i <= 5000000; ++i) {
			if (prime[sumPrimes[i]])
				f[i] = 1;
			f[i] += f[i - 1];
		}

		InputReader in = new InputReader(System.in);

		while (true) {
			int a = in.nextInt();
			if (a == 0)
				break;

			int b = in.nextInt();
			System.out.println(f[b] - f[a - 1]);
		}
		
		System.exit(0);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}
