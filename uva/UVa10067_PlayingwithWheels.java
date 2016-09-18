package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1008 (10067 - Playing with Wheels) */
/* SUBMISSION: 09054649 */
/* SUBMISSION TIME: 2011-07-16 19:14:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10067_PlayingwithWheels {
	
	static Set<String> forbidden;
	
	static Map<String, Integer> bfs(String s) {
		Map<String, Integer> distance = new HashMap<String, Integer>();
		Set<String> visited = new HashSet<String>();
		Queue<String> Q = new LinkedList<String>();
		
		visited.add(s);
		distance.put(s, 0);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			String v = Q.poll();

			for (int i = 0; i < 4; ++i) {
				char[] c = v.toCharArray();
				c[i] = c[i] > '0' ? (char)(c[i] - 1) : '9';
				String w = String.valueOf(c);
				
				if (!forbidden.contains(w) && !visited.contains(w)) {
					visited.add(w);
					int dist = distance.get(v) + 1;
					distance.put(w, dist);
					Q.offer(w);
				}
				
				c = v.toCharArray();
				c[i] = c[i] < '9' ? (char)(c[i] + 1) : '0';
				w = String.valueOf(c);
				
				if (!forbidden.contains(w) && !visited.contains(w)) {
					visited.add(w);
					int dist = distance.get(v) + 1;
					distance.put(w, dist);
					Q.offer(w);
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			
			String start = in.next() + in.next() + in.next() + in.next();
			String dest = in.next() + in.next() + in.next() + in.next();
			
			int n = in.nextInt();
			forbidden = new HashSet<String>();
			for (int i = 0; i < n; ++i)
				forbidden.add(in.next() + in.next() + in.next() + in.next());
			
			Map<String, Integer> d = bfs(start);
			if (!d.containsKey(dest))
				System.out.println(-1);
			else
				System.out.println(d.get(dest));
		}
		
		in.close();
		System.exit(0);
	}
}