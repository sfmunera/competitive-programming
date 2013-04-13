package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2756 (11709 - Trust groups) */
/* SUBMISSION: 10354256 */
/* SUBMISSION TIME: 2012-07-18 21:14:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11709_Trustgroups {
	
	static boolean[] visited;
	static Vertex[] G, Gt;
	static Stack<Integer> sort;
	static int[] leader;
	static int N;
	static Map<String, Integer> map;
	
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
	
	static void dfs2(int u, int l) {
		visited[u] = true;
		leader[u] = l;
		for (int v : Gt[u].adj)
			if (!visited[v])
				dfs2(v, l);
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
		leader = new int[N];
		int numComps = 0;
		while (!sort.isEmpty()) {
			int x = sort.pop();
			if (!visited[x]) {
				++numComps;
				dfs2(x, x);
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
			
			map = new HashMap<String, Integer>();
			G = new Vertex[N];
			Gt = new Vertex[N];
			for (int i = 0; i < N; ++i) {
				G[i] = new Vertex();
				Gt[i] = new Vertex();
				map.put(in.readLine(), i);
			}
			for (int i = 0; i < M; ++i) {
				int u = map.get(in.readLine());
				int v = map.get(in.readLine());
				G[u].adj.add(v);
			}
			System.out.println(scc());
		}
		
		in.close();
		System.exit(0);
	}
}
