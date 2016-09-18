package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1474 (10533 - Digit Primes) */
/* SUBMISSION: 09154075 */
/* SUBMISSION TIME: 2011-08-15 19:15:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10533_DigitPrimes {
	
	static boolean[] prime;
	static int[] primeDigits;
	
	static int sumDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		
		return sum;
	}
	
	static boolean[] sieve(int N) {
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		
		for (int p = 2; p * p <= N; ++p)
			if (prime[p])
				for (int i = p * p; i <= N; i += p)
					prime[i] = false;
		return prime;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		primeDigits = new int[1000010];
		prime = sieve(1000010);
		
		for (int i = 1; i < 1000010; ++i) {
			primeDigits[i] = primeDigits[i - 1];
			if (prime[i] && prime[sumDigits(i)])
				++primeDigits[i];
		}
		
		int T = Integer.parseInt(in.readLine());
		String line;
		StringTokenizer stk;
		StringBuilder res = new StringBuilder();
		while (T-- > 0) {
			line = in.readLine();
			stk = new StringTokenizer(line);
			
			int t1 = Integer.parseInt(stk.nextToken());
			int t2 = Integer.parseInt(stk.nextToken());
			
			res.append((primeDigits[t2] - primeDigits[t1 - 1]) + "\n");
		}
		System.out.print(res);
	}
}