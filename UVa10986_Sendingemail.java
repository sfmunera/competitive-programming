package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1927 (10986 - Sending email) */
/* SUBMISSION: 10268085 */
/* SUBMISSION TIME: 2012-06-28 17:00:42 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10986_Sendingemail {
	
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

	static class QueueItem implements Comparable<QueueItem> {
		int v, dist;
		public QueueItem(int v, int dist) {
			this.v = v; this.dist = dist;
		}
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}

	static int dijkstra(int s, int t) {
		int[] dist = new int[N];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		Arrays.fill(dist, INF);
		dist[s] = 0;
		Q.offer(new QueueItem(s, 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.v; int d = q.dist;
			if (d == dist[u])
				for (Edge e : G[u].adj) {
					int v = e.to; int w = e.w;
					if (dist[u] + w < dist[v]) {
						dist[v] = dist[u] + w;
						Q.offer(new QueueItem(v, dist[v]));
					}
				}
		}
		return dist[t];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		for (int k = 1; k <= K; ++k) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			int S = Integer.parseInt(parts[2]);
			int T = Integer.parseInt(parts[3]);
			
			G = new Vertex[N];
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex();
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]);
				int v = Integer.parseInt(parts[1]);
				int w = Integer.parseInt(parts[2]);
				
				G[u].adj.add(new Edge(v, w));
				G[v].adj.add(new Edge(u, w));
			}
			
			int ans = dijkstra(S, T);
			if (ans != INF)
				System.out.printf("Case #%d: %d\n", k, ans);
			else
				System.out.printf("Case #%d: unreachable\n", k);
		}
		
		in.close();
		System.exit(0);
	}
}
