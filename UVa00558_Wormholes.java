package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 499 (558 - Wormholes) */
/* SUBMISSION: 10268314 */
/* SUBMISSION TIME: 2012-06-28 18:08:04 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00558_Wormholes {
	
	static int N;
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

	static boolean bellmanford(int s) {
		int[] dist = new int[N];
		
		Arrays.fill(dist, INF);
		dist[s] = 0;
		for (int i = 0; i < N - 1; ++i)
			for (int u = 0; u < N; ++u)
				for (Edge e : G[u].adj) {
					int v = e.to; int w = e.w;
					dist[v] = Math.min(dist[v], dist[u] + w);
				}
		for (int u = 0; u < N; ++u)
			for (Edge e : G[u].adj) {
				int v = e.to; int w = e.w;
					if (dist[v] > dist[u] + w)
						return true;
			}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		while (K-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			G = new Vertex[N];
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex();
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int x = Integer.parseInt(parts[0]);
				int y = Integer.parseInt(parts[1]);
				int t = Integer.parseInt(parts[2]);
				
				G[x].adj.add(new Edge(y, t));
			}
			
			boolean ans = bellmanford(0);
			System.out.println((ans ? "" : "not ") + "possible");
		}
		
		in.close();
		System.exit(0);
	}
}