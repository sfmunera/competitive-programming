package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 855 (914 - Jumping Champion) */
/* SUBMISSION: 09082452 */
/* SUBMISSION TIME: 2011-07-26 18:11:15 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00914_JumpingChampion {
	
	static boolean[] sieve(int N) {
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		
		primes[0] = primes[1] = false;
		
		for (int p = 2; p * p <= N; ++p)
			if (primes[p])
				for (int i = p + p; i <= N; i += p)
					primes[i] = false;
		return primes;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] primes = sieve(1000000);
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int L = Integer.parseInt(stk.nextToken());
			int U = Integer.parseInt(stk.nextToken());
			
			int prev = -1;
			int maxdiff = 0;
			int maxAt = 0;
			boolean found = false;
			int[] diff = new int[1000000];
			for (int i = L; i <= U; ++i) {
				if (!primes[i])
					continue;
				if (prev != -1) {
					++diff[i - prev];
					maxdiff = Math.max(maxdiff, i - prev);
					found = true;
				}
				prev = i;
			}
			if (found) {
				int cnt = 1;
				for (int i = 1; i <= maxdiff; ++i)
					if (diff[i] > diff[maxAt]) {
						maxAt = i;
						cnt = 1;
					} else if (diff[i] == diff[maxAt])
						++cnt;
				if (cnt > 1)
					found = false;
			}
			if (found)
				System.out.println("The jumping champion is " + maxAt);
			else
				System.out.println("No jumping champion");
		}
		
		in.close();
		System.exit(0);
	}
}