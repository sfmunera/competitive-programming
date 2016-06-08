package codeforces;

import java.io.*;
import java.util.*;

public class BearAndPrime100 {

	static boolean isPrime(InputReader in) {
		int[] primes = {2, 3,5,7,11,13,17,19,23,29,31,37,41,43,47};
		
		boolean prime = true;	
		String ans;
		for (int i = 0; i < primes.length && prime; ++i) {
			System.out.println(primes[i]);
			System.out.flush();
			ans = in.next();
			if (ans.equals("yes")) {
				for (int p = primes[i] * primes[i]; p <= 100; p *= primes[i]) {
					System.out.println(p);
					System.out.flush();
					ans = in.next();
					if (ans.equals("yes")) {
						prime = false;
						break;
					}
				}

				for (int j = primes.length - 1; j > i && prime; --j) {
					System.out.println(primes[j]);
					System.out.flush();
					ans = in.next();
					if (ans.equals("yes")) {
						prime = false;
						break;
					}

				}
				break;
			}
		}
		
		return prime;
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		System.out.println(isPrime(in) ? "prime" : "composite");
		System.out.flush();
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
