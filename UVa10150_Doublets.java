package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1091 (10150 - Doublets) */
/* SUBMISSION: 09054925 */
/* SUBMISSION TIME: 2011-07-16 20:24:42 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10150_Doublets {
	
	static Set<String> dict;
	
	static Map<String, String> bfs(String s) {
		Map<String, String> parent = new HashMap<String, String>();
		Set<String> visited = new HashSet<String>();
		Queue<String> Q = new LinkedList<String>();
		
		visited.add(s);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			String v = Q.poll();
			
			char[] c = v.toCharArray();
			
			for (int i = 0; i < c.length; ++i) {
				char tmp = c[i];
				for (char ch = 'a'; ch <= 'z'; ++ch) {
					if (ch == c[i])
						continue;
					c[i] = ch;
					String w = String.valueOf(c);
					if (dict.contains(w) && !visited.contains(w)) {
						visited.add(w);
						parent.put(w, v);
						Q.offer(w);
					}
					c[i] = tmp;
				}
			}
		}
		
		return parent;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		dict = new HashSet<String>();
		while (true) {
			String line = in.readLine();
			if (line.isEmpty())
				break;
			dict.add(line);
		}
		
		boolean first = true;
		while (true) {
			String line = in.readLine();
			if (line == null)
				break;
			
			if (first)
				first = false;
			else
				System.out.println();
			
			String[] pair = line.split("[ ]");
			Map<String, String> parent = bfs(pair[0]);
			
			if (!parent.containsKey(pair[1]))
				System.out.println("No solution.");
			else {
				Stack<String> route = new Stack<String>();
				String cur = pair[1];
				route.push(cur);
				while (!cur.equals(pair[0])) {
					String p = parent.get(cur);
					route.push(p);
					cur = p;
				}
				
				while (!route.isEmpty())
					System.out.println(route.pop());
			}
		}
		
		in.close();
		System.exit(0);
	}
}