package codeforces;

import java.util.*;

public class Sets {
	
	static Set<Integer> seen;
	static Map<Integer, List<Integer>> groups;
	static void dfs(int u, int color, Map<Integer, Set<Integer>> graph) {
		seen.add(u);
		if (!groups.containsKey(color)) groups.put(color, new ArrayList<>());
		groups.get(color).add(u);
		
		for (int v : graph.get(u)) {
			if (!seen.contains(v)) {
				dfs(v, color, graph);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		if (n == 2) {
			int k = in.nextInt();
			System.out.println("1 " + in.nextInt());
			System.out.print((k - 1));
			for (int i = 0; i < k - 1; ++i) {
				System.out.print(" " + in.nextInt());
			}
			System.out.println();
		} else {

			Map<Integer, Set<Integer>> graph = new HashMap<>();
			Set<Integer> existing = new HashSet<>();
			for (int line = 0; line < n * (n - 1) / 2; ++line) {
				int k = in.nextInt();
				Set<Integer> s = new HashSet<>();
				for (int i = 0; i < k; ++i) {
					int x = in.nextInt();
					s.add(x);
				}
				for (int x : s) {
					if (!graph.containsKey(x)) {
						graph.put(x, new HashSet<>());
					}
				}

				for (int x : s) {
					for (int y : s) {
						if (x == y) continue;
						// add edge for two new nodes
						if (!existing.contains(x) && !existing.contains(y)) {
							graph.get(x).add(y);
							graph.get(y).add(x);
						}
					}
				}
				//System.out.println(graph);

				for (int x : s) {
					existing.add(x);
				}

				for (int u : s) {
					List<Integer> toRemove = new ArrayList<>();
					for (int v : graph.get(u)) {
						if (!s.contains(v)) {
							toRemove.add(v);
						}
					}
					for (int v : toRemove) {
						graph.get(u).remove(v);
						graph.get(v).remove(u);
					}
				}
			}
			seen = new HashSet<>();
			groups = new HashMap<>();
			
			int color = 0;
			for (int u : graph.keySet()) {
				if (!seen.contains(u)) {
					dfs(u, color++, graph);
				}
			}
			
			for (int c : groups.keySet()) {
				int size = groups.get(c).size();
				System.out.print(size);
				for (int x : groups.get(c)) {
					System.out.print(" " + x);
				}
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
