package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1730 (10789 - Prime Frequency) */
/* SUBMISSION: 09087267 */
/* SUBMISSION TIME: 2011-07-28 03:19:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10789_PrimeFrequency {
	
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
		boolean[] prime = sieve(2000);
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int[] freq = new int[256];
			char[] str = in.readLine().toCharArray();
			
			for (char c : str)
				++freq[c];
			String res = "";
			for (char c : str)
				if (prime[freq[c]] && !res.contains(String.valueOf(c)))
					res += c;
			char[] resc = res.toCharArray();
			Arrays.sort(resc);
			System.out.println("Case " + t + ": " + (resc.length == 0 ? "empty" : String.valueOf(resc)));
		}
		
		in.close();
		System.exit(0);
	}
}