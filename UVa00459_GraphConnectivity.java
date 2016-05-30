package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 400 (459 - Graph Connectivity) */
/* SUBMISSION: 09040096 */
/* SUBMISSION TIME: 2011-07-11 20:52:49 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00459_GraphConnectivity {
	static List<Edge>[] G;
	static boolean[] visited;
	static int N;
	
	static class Edge {
		int to;
		
		public Edge(int to) {
			this.to = to;
		}
	}
	
	static void dfs(int v) {
		if (visited[v])
			return;
		
		visited[v] = true;
		for (Edge w : G[v])
			dfs(w.to);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		for (int t = 1; t <= T; ++t) {
			N = in.readLine().charAt(0) - 'A' + 1;
			G = new ArrayList[N];
			visited = new boolean[N];
			int cnt = 0;
			
			for (int i = 0; i < N; ++i)
				G[i] = new ArrayList<Edge>();
			
			String line;
			while ((line = in.readLine()) != null) {
				if (line.isEmpty())
					break;
				int from = line.charAt(0) - 'A';
				int to = line.charAt(1) - 'A';
				
				G[from].add(new Edge(to));
				G[to].add(new Edge(from));
			}
			
			for (int i = 0; i < N; ++i)
				if (!visited[i]) {
					++cnt;
					dfs(i);
				}
			
			if (t > 1)
				System.out.println();
			System.out.println(cnt);
		}
	}
}