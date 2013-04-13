package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2499 (11504 - Dominos) */
/* SUBMISSION: 10354370 */
/* SUBMISSION TIME: 2012-07-18 21:51:25 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11504_Dominos {

	static boolean[] visited;
	static Vertex[] G;
	static Stack<Integer> sort;
	static int N;
	
	static class Vertex {
		List<Integer> adj;
		public Vertex() {
			adj = new ArrayList<Integer>();
		}
	}

	static void dfs(int u) {
		visited[u] = true;
		for (int v : G[u].adj)
			if (!visited[v])
				dfs(v);
		sort.push(u);
	}
	
	static void dfs2(int u) {
		visited[u] = true;
		for (int v : G[u].adj)
			if (!visited[v])
				dfs2(v);
	}
	
	static void topsort() {
		visited = new boolean[N];
		sort = new Stack<Integer>();
		
		for (int i = N - 1; i >= 0; --i)
			if (!visited[i])
				dfs(i);
	}
	
	static int scc() {
		topsort();
		visited = new boolean[N];
		int numComps = 0;
		while (!sort.isEmpty()) {
			int x = sort.pop();
			if (!visited[x]) {
				++numComps;
				dfs2(x);
			}
		}
		return numComps;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);

			G = new Vertex[N];
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex();
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]) - 1;
				int v = Integer.parseInt(parts[1]) - 1;
				G[u].adj.add(v);
			}
			System.out.println(scc());
		}
		
		in.close();
		System.exit(0);
	}
}
