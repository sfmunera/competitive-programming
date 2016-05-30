package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 465 (524 - Prime Ring Problem) */
/* SUBMISSION: 09033241 */
/* SUBMISSION TIME: 2011-07-09 17:38:02 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00524_PrimeRingProblem {
	
	static boolean[] primes;
	static int n;
	static int[] ring;
	static boolean[] used;
	
	static void solve(int k) {
		if (k == n - 1) {
			if (primes[ring[k] + 1]) {
				String res = "";
				for (int i = 0; i < n; ++i) {
					if (i > 0) res += " ";
					res += ring[i];
				}
				System.out.println(res);
			}
			return;
		}
		
		for (int i = 2; i <= n; ++i) {
			if (used[i] || !primes[ring[k] + i])
				continue;
			used[i] = true;
			ring[k + 1] = i;
			solve(k + 1);
			used[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		primes = new boolean[32];
		primes[2] = primes[3] = primes[5] = primes[7] = primes[11] = primes[13] = 
			primes[17] = primes[19] = primes[23] = primes[29] = primes[31] = true;
		
		int t = 1;
		while (in.hasNextInt()) {
			n = in.nextInt();
			ring = new int[n];
			used = new boolean[n + 1];
			
			used[1] = true;
			ring[0] = 1;
			
			if (t > 1)
				System.out.println();
			System.out.println("Case " + t + ":");
			solve(0);
			++t;
		}
	}
}