package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1889 (10948 - The primary problem) */
/* SUBMISSION: 09087362 */
/* SUBMISSION TIME: 2011-07-28 03:44:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10948_Theprimaryproblem {
	
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
		boolean[] prime = sieve(1000000);
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			boolean found = false;
			System.out.println(N + ":");
			for (int i = 0; i <= N / 2; ++i)
				if (prime[i] && prime[N - i]) {
					found = true;
					System.out.println(i + "+" + (N - i));
					break;
				}
			if (!found)
				System.out.println("NO WAY!");
		}
		
		in.close();
		System.exit(0);
	}
}