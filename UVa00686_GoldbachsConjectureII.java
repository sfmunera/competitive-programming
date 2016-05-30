package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 627 (686 - Goldbach's Conjecture (II)) */
/* SUBMISSION: 09081829 */
/* SUBMISSION TIME: 2011-07-26 15:36:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00686_GoldbachsConjectureII {
	
	static boolean[] sieve(int N) {
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		
		primes[0] = primes[1] = false;
		
		for (int p = 2; p * p <= N; ++p)
			if (primes[p])
				for (int i = p + p; i <= N; i += p)
					primes[i] = false;
		return primes;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int MAX = 1 << 15;
		boolean[] primes = sieve(MAX);
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			int cnt = 0;
			for (int p = 2; p <= N / 2; ++p)
				if (primes[p] && primes[N - p])
					++cnt;
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}