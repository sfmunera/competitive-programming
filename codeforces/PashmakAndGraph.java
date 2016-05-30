package codeforces;

import java.util.*;

public class PashmakAndGraph {
	
	static int[] max;
	
	static class Edge {
		int to, w;
		Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	static List<List<Edge>> graph;
	
	static void dfs(int u, int curw) {
		for (Edge e : graph.get(u)) {
			int v = e.to;
			int wn = e.w;
			
			if (wn > curw && max[v] < 1 + max[u]) {
				max[v] = 1 + max[u];
				dfs(v, wn);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		max = new int[n];
		graph = new ArrayList<List<Edge>>();
		
		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Edge>());
		}
		
		int[] indeg = new int[n];
		
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			int w = in.nextInt();
			
			graph.get(u).add(new Edge(v, w));
			++indeg[v];
		}
		
		for (int i = 0; i < n; ++i) {
			if (indeg[i] == 0) {
				dfs(i, 0);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			ans = Math.max(ans, max[i]);
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
