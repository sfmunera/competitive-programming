package codeforces;

import java.util.*;

public class TPrimes {
	
	static Set<Long> getTPrimes() {
		int max = (int) 1e6;
		boolean[] prime = new boolean[max + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int p = 2; p * p <= max; ++p)
			if (prime[p])
				for (int i = p * p; i <= max; i += p)
					prime[i] = false;
		
		Set<Long> tPrimes = new HashSet<Long>();
		for (int i = 2; i <= max; ++i)
			if (prime[i])
				tPrimes.add((long) i * i);
		
		return tPrimes;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = in.nextInt();
		Set<Long> tPrimes = getTPrimes();
		for (int i = 0; i < n; ++i) {
			long number = in.nextLong();
			sb.append((tPrimes.contains(number) ? "YES" : "NO") + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
