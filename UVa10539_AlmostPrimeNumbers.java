package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1480 (10539 - Almost Prime Numbers) */
/* SUBMISSION: 10180751 */
/* SUBMISSION TIME: 2012-06-01 23:16:31 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10539_AlmostPrimeNumbers {
	
	static List<Long> sieve(int N) {
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		
		primes[0] = primes[1] = false;
		for (int p = 2; p * p <= N; ++p)
			if (primes[p])
				for (int i = p * p; i <= N; i += p)
					primes[i] = false;
		
		List<Long> list = new ArrayList<Long>();
		for (int i = 2; i <= N; ++i)
			if (primes[i])
				list.add((long)i);
		return list;
	}
	
	static int binSearch(List<Long> list, long x) {
		int lo = 0;
		int hi = list.size() - 1;
		
		if (x > list.get(hi))
			return -1;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (list.get(mid) < x)
				lo = mid + 1;
			else
				hi = mid;
		}
		
		return lo;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 1000005;
		List<Long> primes = sieve(N);
		List<Long> almost = new ArrayList<Long>();
		
		for (long x : primes) {
				long a = x * x;
				while (a > 0 && a <= 1000000000010L) {
					almost.add(a);
					a *= x;
				}
			}
		Collections.sort(almost);
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			long L = Long.parseLong(parts[0]);
			long U = Long.parseLong(parts[1]);
			
			int ind1 = binSearch(almost, L);

			int ans = 0;
			for (int i = ind1; i < almost.size() && almost.get(i) <= U; ++i)
				++ans;
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
