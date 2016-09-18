package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1335 (10394 - Twin Primes) */
/* SUBMISSION: 09085853 */
/* SUBMISSION TIME: 2011-07-27 17:04:28 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10394_TwinPrimes {
	
	static class Pair {
		int p1;
		int p2;
		
		public Pair(int p1, int p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
		
		public String toString() {
			return "(" + this.p1 + ", " + this.p2 + ")";
		}
	}
	
	static List<Pair> twins(int N) {
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		for (int p = 2; p * p <= N; ++p)
			if (prime[p])
				for (int i = p * p; i <= N; i += p)
					prime[i] = false;
		
		List<Pair> twins = new ArrayList<Pair>();
		for (int i = 0; i <= N - 2; ++i)
			if (prime[i] && prime[i + 2])
				twins.add(new Pair(i, i + 2));
		
		return twins;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<Pair> twins = twins(20000010);
		
		String line;
		while ((line = in.readLine()) != null) {
			int S = Integer.parseInt(line);
			System.out.println(twins.get(S - 1));
		}
		
		in.close();
		System.exit(0);
	}
}