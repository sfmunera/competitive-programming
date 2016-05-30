package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 941 (10000 - Longest Paths) */
/* SUBMISSION: 10268914 */
/* SUBMISSION TIME: 2012-06-28 21:55:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10000_LongestPaths {
	
	static int N;
	static Stack<Integer> sort;
	static boolean[] visited;
	static Vertex[] G;
	static final int INF = Integer.MAX_VALUE;
		
	static class Vertex {
		List<Edge> adj;
		public Vertex() {
			adj = new ArrayList<Edge>();
		}
	}

	static class Edge {
		int to,	w;
		public Edge(int to, int w) {
			this.to = to; this.w = w;
		}
	}

	static void dfs(int s) {
		visited[s] = true;
		
		for (Edge e : G[s].adj)
			if (!visited[e.to])
				dfs(e.to);
		sort.push(s);
	}
		
	static void topsort() {
		visited = new boolean[N];
		sort = new Stack<Integer>();
		
		for (int i = 0; i < N; ++i)
			if (!visited[i])
				dfs(i);
	}
		
	static int[] dagLongestPath(int s) {
		int[] dist = new int[N];
		int[] p = new int[N];
		
		topsort();
		Arrays.fill(dist, -INF);
		Arrays.fill(p, -1);
		dist[s] = 0;
		while (!sort.isEmpty()) {
			int u = sort.pop();
			for (Edge e : G[u].adj) {
				int v = e.to, w = e.w;
				if (dist[u] + w > dist[v]) {
					dist[v] = dist[u] + w;
					p[v] = u;
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int k = 1;
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			G = new Vertex[N];
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex();
			
			int s = Integer.parseInt(in.readLine()) - 1;
			while (true) {
				String[] parts = in.readLine().split("[ ]+");
				int p = Integer.parseInt(parts[0]);
				int q = Integer.parseInt(parts[1]);
				if (p == 0 && q == 0)
					break;
				
				G[p - 1].adj.add(new Edge(q - 1, 1));
			}
			
			int[] dist = dagLongestPath(s);
			int t = -1;
			int max = 0;
			for (int i = 0; i < N; ++i)
				if (dist[i] > max) {
					max = dist[i];
					t = i;
				}
			System.out.println("Case " + k + ": The longest path from " + (s + 1) + " has length " + max + ", finishing at " + (t + 1) + ".");
			System.out.println();
			++k;
			
		}
		
		in.close();
		System.exit(0);
	}
}