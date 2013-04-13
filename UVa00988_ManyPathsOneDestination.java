package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 929 (988 - Many Paths, One Destination) */
/* SUBMISSION: 10269858 */
/* SUBMISSION TIME: 2012-06-29 05:55:19 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00988_ManyPathsOneDestination {
	
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
	
	static int[] countPaths() {
		int[] cnt = new int[N];
		
		topsort();
		cnt[0] = 1;
		while (!sort.isEmpty()) {
			int u = sort.pop();
			for (Edge e : G[u].adj) {
				int v = e.to;
				cnt[v] += cnt[u];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		String line;
		while ((line = in.readLine()) != null) {
			N = Integer.parseInt(line);
			if (N == 0) break;
			
			G = new Vertex[N];
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex();
			
			boolean[] isDeath = new boolean[N];
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int M = Integer.parseInt(parts[0]);
				if (M == 0) {
					isDeath[i] = true;
					continue;
				}
				for (int j = 1; j <= M; ++j)
					G[i].adj.add(new Edge(Integer.parseInt(parts[j]), 1));
			}
			int[] cnt = countPaths();
			int ans = 0;
			for (int i = 0; i < N; ++i)
				if (isDeath[i])
					ans += cnt[i];
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(ans);
			
			in.readLine();
		}
		
		in.close();
		System.exit(0);
	}
}
