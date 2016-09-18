package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3654 (1213 - Sum of Different Primes) */
/* SUBMISSION: 10180833 */
/* SUBMISSION TIME: 2012-06-02 00:54:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01213_SumofDifferentPrimes {
	
	static int N, K;
	static List<Integer> primes;
	static int[][][] memo;
	
	static List<Integer> sieve(int N) {
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		
		primes[0] = primes[1] = false;
		for (int p = 2; p * p <= N; ++p)
			if (primes[p])
				for (int i = p * p; i <= N; i += p)
					primes[i] = false;
		List<Integer> list = new ArrayList<Integer>();
		for (int p = 2; p <= N; ++p)
			if (primes[p])
				list.add(p);
		return list;
	}
	
	static int solve(int n, int k, int j) {
		if (k == K && n == 0)
			return 1;
		
		int p = primes.get(j);
		if (n < 0 || k == K || p > n)
			return 0;
		
		if (memo[n][k][j] != -1)
			return memo[n][k][j];

		return memo[n][k][j] = solve(n, k, j + 1) + solve(n - p, k + 1, j + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		primes = sieve(2000);
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			K = Integer.parseInt(parts[1]);
			
			if (N == 0 && K == 0)
				break;
			
			int MAXN = 1120;
			int MAXK = 14;
			int MAXP = 200;
			
			memo = new int[MAXN + 5][MAXK + 5][MAXP + 5];
			for (int i = 0; i < MAXN + 5; ++i)
				for (int j = 0; j < MAXK + 5; ++j)
					for (int k = 0; k < MAXP + 5; ++k)
						memo[i][j][k] = -1;
			
			System.out.println(solve(N, 0, 0));
		}
		
		in.close();
		System.exit(0);
	}
}
