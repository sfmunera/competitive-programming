package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1865 (10924 - Prime Words) */
/* SUBMISSION: 09087313 */
/* SUBMISSION TIME: 2011-07-28 03:31:08 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10924_PrimeWords {
	
	static boolean[] sieve(int N) {
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		
		prime[0] = false;
		for (int p = 2; p * p <= N; ++p)
			if (prime[p])
				for (int i = p * p; i <= N; i += p)
					prime[i] = false;
		return prime;
	}
	
	static int value(String w) {
		int sum = 0;
		for (char c : w.toCharArray())
			if (Character.isUpperCase(c))
				sum += c - 'A' + 27;
			else
				sum += c - 'a' + 1;
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = sieve(1100);
		
		String word;
		while ((word = in.readLine()) != null) {
			if (prime[value(word)])
				System.out.println("It is a prime word.");
			else
				System.out.println("It is not a prime word.");
		}
		
		in.close();
		System.exit(0);
	}
}