package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 484 (543 - Goldbach's Conjecture) */
/* SUBMISSION: 09081904 */
/* SUBMISSION TIME: 2011-07-26 15:52:33 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00543_GoldbachsConjecture {
	
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
		int MAX = 1000000;
		boolean[] primes = sieve(MAX);
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			for (int p = 2; p <= N / 2; ++p)
				if (primes[p] && primes[N - p]) {
					System.out.println(N + " = " + p + " + " + (N - p));
					break;
				}
		}
		
		in.close();
		System.exit(0);
	}
}