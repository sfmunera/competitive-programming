package codeforces;

import java.util.*;

public class Reposts {
	
	static final String INITIAL = "polycarp";
	
	static int solve(String node, Set<String> seen, Map<String, Set<String>> graph) {
		seen.add(node);
		
		int max = 0;
		for (String next : graph.get(node)) {
			if (!seen.contains(next)) {
				max = Math.max(max, solve(next, seen, graph));
			}
		}
		return 1 + max;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Map<String, Set<String>> graph = new HashMap<>();
		
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String to = in.next().toLowerCase();
			in.next();
			String from = in.next().toLowerCase();
			if (!graph.containsKey(from)) graph.put(from, new HashSet<String>());
			if (!graph.containsKey(to)) graph.put(to, new HashSet<String>());
			graph.get(from).add(to);
		}
		
		int ans = solve(INITIAL, new HashSet<String>(), graph);
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
