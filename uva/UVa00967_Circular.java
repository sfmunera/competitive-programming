package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 908 (967 - Circular) */
/* SUBMISSION: 09168352 */
/* SUBMISSION TIME: 2011-08-19 00:02:02 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00967_Circular {
	
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
		int[] circular = new int[1000000];
		for (int i = 1; i < 1000000; ++i) {
			int n = i;
			int pow10 = (int)Math.floor(Math.log10(n));
			
			boolean ok = true;
			for (int k = 0; k <= pow10; ++k) {
				if (!prime[n]) {
					ok = false;
					break;
				}
				int pow = (int)Math.round(Math.pow(10, pow10));
				n = (n % pow) * 10 + n / pow;
			}
			circular[i] = circular[i - 1] + (ok ? 1 : 0);
		}
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int a = Integer.parseInt(stk.nextToken());
			if (a == -1)
				break;
			int b = Integer.parseInt(stk.nextToken());
			
			int res = circular[b] - circular[a - 1];
			if (res == 0)
				sb.append("No Circular Primes.\n");
			else if (res == 1)
				sb.append("1 Circular Prime.\n");
			else
				sb.append(res + " Circular Primes.\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}