package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 956 (10015 - Joseph's Cousin) */
/* SUBMISSION: 11080934 */
/* SUBMISSION TIME: 2012-12-28 02:29:30 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10015_JosephsCousin {
	
	static List<Integer> primes;
	
	static int simulate(int N) {
		int p = -1;
		List<Integer> q = new ArrayList<Integer>();
		
		for (int i = 0; i < N; ++i)
			q.add(i + 1);
		
		for (int r = 0; r < N - 1; ++r) {
			int M = primes.get(r);
			p = (p + M) % q.size();
			q.remove(p);
			--p;
			if (p < 0) p = q.size() - 1;
		}
		return q.get(0);
	}
	
	static List<Integer> sieve(int N) {
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int p = 2; p * p <= N; ++p)
			if (prime[p])
				for (int i = p * p; i <= N; i += p)
					prime[i] = false;
		
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i <= N; ++i)
			if (prime[i])
				primes.add(i);
		return primes;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		primes = sieve(40000);
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			System.out.println(simulate(N));
		}
		
		in.close();
		System.exit(0);
	}
}
