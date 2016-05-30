package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3253 (12101 - Prime Path) */
/* SUBMISSION: 10239178 */
/* SUBMISSION TIME: 2012-06-19 13:59:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12101_PrimePath {
	
	static Set<Integer> primes;
	
	static boolean isPrime(int p) {
		if (p < 2) return false;
		if (p == 2) return true;
		if (p % 2 == 0) return false;
		
		for (int i = 3; i * i <= p; i += 2)
			if (p % i == 0)
				return false;
		return true;
	}
	
	static int bfs(int s, int t) {
		Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		
		distance.put(s, 0);
		seen.add(s);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int x = Q.poll();
			
			if (x == t)
				return distance.get(x);
			
			char[] c = String.valueOf(x).toCharArray();
			for (int i = 0; i < c.length; ++i) {
				for (char d = '0'; d <= '9'; ++d) {
					if (i == 0 && d == '0')
						continue;
					if (c[i] != d) {
						char ch = c[i];
						c[i] = d;
						int nxt = Integer.parseInt(String.valueOf(c));
						
						if (primes.contains(nxt) && !seen.contains(nxt)) {
							distance.put(nxt, distance.get(x) + 1);
							seen.add(nxt);
							Q.offer(nxt);
						}
						
						c[i] = ch;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		primes = new HashSet<Integer>();
		for (int p = 1000; p < 10000; ++p)
			if (isPrime(p))
				primes.add(p);
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int s = Integer.parseInt(parts[0]);
			int t = Integer.parseInt(parts[1]);
			
			int d = bfs(s, t);
			if (d == -1)
				System.out.println("Impossible");
			else
				System.out.println(d);
		}
		
		in.close();
		System.exit(0);
	}
}
