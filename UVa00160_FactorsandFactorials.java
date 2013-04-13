package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 96 (160 - Factors and Factorials) */
/* SUBMISSION: 08927530 */
/* SUBMISSION TIME: 2011-06-07 20:23:22 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00160_FactorsandFactorials {
	
	static List<Integer> sieve(int n) {
		int p = 2;
		boolean[] P = new boolean[n];
		Arrays.fill(P, true);
		P[0] = P[1] = false;
		
		while (p * p <= n) {
			for (int i = p + p; i < n; i += p)
				P[i] = false;
			for (int i = p + 1; i < n; ++i)
				if (P[i]) {
					p = i;
					break;
				}
		}
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i)
			if (P[i])
				primes.add(i);
		return primes;
	}
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			List<Integer> primes = sieve(100);
			
			while (true) {
				int N = in.nextInt();
				if (N == 0)
					break;
				
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int i = 2; i <= N; ++i) {
					int tmp = i;
					for (int j = 0; j < primes.size() && tmp != 1; ++j) {
						int cnt = 0;
						int p = primes.get(j);
						while (tmp % p == 0) {
							tmp /= p;
							++cnt;
						}
						if (map.containsKey(p))
							map.put(p, map.get(p) + cnt);
						else
							map.put(p, cnt);
					}
				}
				System.out.printf("%3d! =", N);

				int cnt = 0;
				for (int x : primes) {
					if (map.containsKey(x)) {
						if (cnt > 0 && cnt % 15 == 0)
							System.out.printf("\n      ");
						System.out.printf("%3d", map.get(x));
						++cnt;
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.exit(0);
		}
	}
}
