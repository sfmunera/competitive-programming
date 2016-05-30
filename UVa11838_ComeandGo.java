package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2938 (11838 - Come and Go) */
/* SUBMISSION: 10354356 */
/* SUBMISSION TIME: 2012-07-18 21:47:14 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11838_ComeandGo {

	static boolean[] visited;
	static Vertex[] G, Gt;
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
		for (int v : Gt[u].adj)
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
		for (int i = 0; i < N; ++i)
			for (int j : G[i].adj)
				Gt[j].adj.add(i);
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
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			if (N == 0 && M == 0) break;
			
			G = new Vertex[N];
			Gt = new Vertex[N];
			for (int i = 0; i < N; ++i) {
				G[i] = new Vertex();
				Gt[i] = new Vertex();
			}
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]) - 1;
				int v = Integer.parseInt(parts[1]) - 1;
				int P = Integer.parseInt(parts[2]);
				G[u].adj.add(v);
				if (P == 2)
					G[v].adj.add(u);
			}
			System.out.println(scc() > 1 ? 0 : 1);
		}
		
		in.close();
		System.exit(0);
	}
}
