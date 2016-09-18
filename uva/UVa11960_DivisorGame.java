package uva;

import java.util.*;
import java.io.*;

public class UVa11960_DivisorGame {
	
	static ArrayList<Integer> primes;
	
	static int divisors(int x) {

		int ans = 1;
		for (int i = 0; ; ++i) {
			int p = primes.get(i);
			if (p > x / p) break;
			int cnt = 0;
			while (x % p == 0) {
				++cnt;
				x /= p;
			}
			ans *= cnt + 1;
		}
		if (x > 1)
			ans *= 2;
		return ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		boolean[] isPrime = new boolean[1000001];
		primes = new ArrayList<Integer>();
		
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int p = 2; p * p <= 1000000; ++p)
			if (isPrime[p])
				for (int i = p * p; i <= 1000000; i += p)
					isPrime[i] = false;
		for (int i = 0; i <= 1000000; ++i)
			if (isPrime[i])
				primes.add(i);
		
		int[] ans = new int[1000001];
		
		ans[0] = 0;
		int max = 0;
		
		for (int i = 1; i <= 1000000; ++i) {
			int nDiv = divisors(i);
			if (nDiv >= max) {
				max = nDiv;
				ans[i] = i;
			} else
				ans[i] = ans[i - 1];
		}
		
		int T = in.nextInt();
		while (T-- > 0) {
			int x = in.nextInt();
			
			System.out.println(ans[x]);
		}
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
