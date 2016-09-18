package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 950 (10009 - All Roads Lead Where?) */
/* SUBMISSION: 09054223 */
/* SUBMISSION TIME: 2011-07-16 16:49:10 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10009_AllRoadsLeadWhere {
	
	static Map<String, ArrayList<String>> G;
	
	static Map<String, String> bfs(String s) {
		Map<String, String> parent = new HashMap<String, String>();
		Set<String> visited = new HashSet<String>();
		Queue<String> Q = new LinkedList<String>();
		
		visited.add(s);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			String v = Q.poll();
			
			for (String w : G.get(v))
				if (!visited.contains(w)) {
					visited.add(w);
					parent.put(w, v);
					Q.offer(w);
				}
		}
		return parent;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			String line = in.readLine();
			String[] parts = line.split("[ ]");
			int M = Integer.parseInt(parts[0]);
			int N = Integer.parseInt(parts[1]);
			
			G = new HashMap<String, ArrayList<String>>();
			for (int i = 0; i < M; ++i) {
				line = in.readLine();
				parts = line.split("[ ]");
				
				if (!G.containsKey(parts[0]))
					G.put(parts[0], new ArrayList<String>());
				if (!G.containsKey(parts[1]))
					G.put(parts[1], new ArrayList<String>());
				
				G.get(parts[0]).add(parts[1]);
				G.get(parts[1]).add(parts[0]);
			}
			
			if (first)
				first = false;
			else
				System.out.println();
			
			for (int i = 0; i < N; ++i) {
				line = in.readLine();
				parts = line.split("[ ]");
				
				Map<String, String> parent = bfs(parts[0]);
				String res = "";
				
				String cur = parts[1];
				res = "" + parts[1].charAt(0);
				while (true) {
					String p = parent.get(cur);
					res = p.charAt(0) + res;
					if (p.equals(parts[0]))
						break;
					cur = p;
				}
				System.out.println(res);
			}
		}
		
		in.close();
		System.exit(0);
	}
}