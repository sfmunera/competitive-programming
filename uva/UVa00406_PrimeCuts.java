package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 347 (406 - Prime Cuts) */
/* SUBMISSION: 09078835 */
/* SUBMISSION TIME: 2011-07-25 17:08:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00406_PrimeCuts {
	
	static boolean[] sieve(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		
		for (int p = 2; p * p <= n; ++p)
			if (primes[p])
				for (int i = p + p; i <= n; i += p)
					primes[i] = false;
		return primes;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] primes = sieve(1000);
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			int N = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			List<Integer> P = new ArrayList<Integer>();
			for (int i = 1; i <= N; ++i)
				if (primes[i])
					P.add(i);
			int len = P.size();
			int mid = len / 2;
			int a = Math.max(0, mid - C);
			int b = Math.min(len - 1, a + 2 * C - 1);
			
			if (len % 2 == 1) {
				a = Math.max(0, mid - C + 1);
				b = Math.min(len - 1, a + 2 * C - 2);
			}
			
			System.out.print(N + " " + C + ":");
			for (int i = a; i <= b ; ++i)
				System.out.print(" " + P.get(i));
			System.out.println();
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
