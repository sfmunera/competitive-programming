package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1141 (10200 - Prime Time) */
/* SUBMISSION: 09154162 */
/* SUBMISSION TIME: 2011-08-15 19:41:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10200_PrimeTime {
	
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
	
	static boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		int[] dp = new int[10001];
		for (int i = 1; i < 10001; ++i) {
			int f = i * i + i + 41;
			dp[i] = dp[i - 1];
			if (isPrime(f))
				++dp[i];
		}
		//System.out.println(Arrays.toString(dp));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			int primes = 0;
			if (a > 0)
				primes = dp[b] - dp[a - 1];
			else
				primes = dp[b] - dp[0] + 1;
			System.out.printf(Locale.ENGLISH, "%.2f%n", 100.0 * (double)primes / (b - a + 1));
		}
		
		in.close();
		System.exit(0);
	}
}