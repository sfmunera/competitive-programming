package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 985 (10044 - Erdos Numbers) */
/* SUBMISSION: 09054421 */
/* SUBMISSION TIME: 2011-07-16 17:54:51 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10044_ErdosNumbers {

	static Map<String, ArrayList<String>> edges;
	static Set<String> vertices;
	
	static Map<String, Integer> bfs(String s) {
		Map<String, Integer> distance = new HashMap<String, Integer>();
		Set<String> visited = new HashSet<String>();
		Queue<String> Q = new LinkedList<String>();
		
		distance.put(s, 0);
		visited.add(s);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			String v = Q.poll();
			
			if (edges.containsKey(v))
				for (String w : edges.get(v))
					if (!visited.contains(w)) {
						visited.add(w);
						distance.put(w, distance.get(v) + 1);
						Q.offer(w);
					}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			String[] parts = line.split("[ ]");
			int P = Integer.parseInt(parts[0]);
			int N = Integer.parseInt(parts[1]);
			
			edges = new HashMap<String, ArrayList<String>>();
			vertices = new TreeSet<String>();
			for (int i = 0; i < P; ++i) {
				line = in.readLine().split("[:]")[0];
				parts = line.split("[,]");
				
				List<String> tmp = new ArrayList<String>();
				int j = 0;
				String prev = "";
				while (j < parts.length) {
					String part = parts[j].trim();
					boolean isLast = false;
					String name = "";
					for (char c : part.toCharArray()) {
						if (Character.isLetter(c))
							name += c;
						if (c == '.') {
							isLast = true;
							name += c;
						}
					}
					if (isLast)
						prev += ", " + name;
					else {
						if (prev.isEmpty()) {
							prev = name;
							++j;
							continue;
						}
						if (!prev.isEmpty() || j == parts.length - 1) {
							tmp.add(prev);
							if (!vertices.contains(prev)) {
								vertices.add(prev);
								edges.put(prev, new ArrayList<String>());
							}
							if (j == parts.length - 1)
								break;
							prev = "";
						}
					}
					tmp.add(prev);
					if (!vertices.contains(prev)) {
						vertices.add(prev);
						edges.put(prev, new ArrayList<String>());
					}
					++j;
					prev = "";
				}
				for (int v = 0; v < tmp.size(); ++v)
					for (int w = v + 1; w < tmp.size(); ++w) {
						edges.get(tmp.get(v)).add(tmp.get(w));
						edges.get(tmp.get(w)).add(tmp.get(v));
					}
			}
			String s = "Erdos, P.";
			Map<String, Integer> distance = bfs(s);
			
			System.out.println("Scenario " + t);
			for (int i = 0; i < N; ++i) {
				String v = in.readLine();
				System.out.print(v + " ");
				if (!distance.containsKey(v))
					System.out.println("infinity");
				else
					System.out.println(distance.get(v));
			}
		}
		
		in.close();
		System.exit(0);
	}
}