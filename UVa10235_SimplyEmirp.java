package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1176 (10235 - Simply Emirp) */
/* SUBMISSION: 09083456 */
/* SUBMISSION TIME: 2011-07-27 02:08:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10235_SimplyEmirp {
	
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
	
	static int reverse(int N) {
		String rev = "";
		
		while (N > 0) {
			rev += N % 10;
			N /= 10;
		}
		return Integer.parseInt(rev);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = sieve(1000000);
		
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			
			if (!prime[N])
				System.out.println(N + " is not prime.");
			else {
				int rev = reverse(N);
				if (!prime[rev] || rev == N)
					System.out.println(N + " is prime.");
				else
					System.out.println(N + " is emirp.");
			}
		}
		
		in.close();
		System.exit(0);
	}
}