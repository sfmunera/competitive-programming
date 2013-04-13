package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2830 (11730 - Number Transformation) */
/* SUBMISSION: 09168288 */
/* SUBMISSION TIME: 2011-08-18 23:25:24 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11730_NumberTransformation {
	
	static int bfs(int s, int t) {
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.offer(s);
		visited.add(s);
		distance.put(s, 0);
		
		while (!Q.isEmpty()) {
			int x = Q.poll();
			if (x == t)
				return distance.get(x);
			
			List<Integer> factors = primeFactors(x);
			//System.out.println("x = " + x + ", " + factors);
			
			for (int f : factors) {
				int w = x + f;
				if (!visited.contains(w) && w <= t) {
					visited.add(w);
					distance.put(w, distance.get(x) + 1);
					Q.offer(w);
				}
			}
		}
		return -1;
	}
	
	static List<Integer> primeFactors(int N) {
		List<Integer> factors = new ArrayList<Integer>();
		
		int M = N;
		for (int p = 2; p * p <= N; ++p) {
			if (N % p == 0)
				factors.add(p);
			while (N % p == 0)
				N /= p;
		}
		if (N > 1 && N != M)
			factors.add(N);
		
		return factors;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int k = 1;
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int s = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			
			if (s == 0 && t == 0)
				break;
			
			System.out.println("Case " + k + ": " + bfs(s, t));
			++k;
		}
		
		in.close();
		System.exit(0);
	}
}