package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 277 (341 - Non-Stop Travel) */
/* SUBMISSION: 10359882 */
/* SUBMISSION TIME: 2012-07-19 22:58:33 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00341_NonStopTravel {
	
	static Vertex[] G;
	static int[] p;
	static int N;
	static final int INF = Integer.MAX_VALUE;
	
	static class Vertex {
		List<Edge> adj;
		public Vertex() {
			this.adj = new ArrayList<Edge>();
		}
	}
	
	static class Edge {
		int to, w;
		public Edge(int to, int w) {
			this.to = to; this.w = w;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		int u, dist;
		public QueueItem(int u, int dist) {
			this.u = u; this.dist = dist;
		}
		
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}
	
	static int dijkstra(int s, int e) {
		int[] dist = new int[N];
		p = new int[N];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		Arrays.fill(dist, INF);
		Arrays.fill(p, -1);
		dist[s] = 0;
		Q.offer(new QueueItem(s, 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			if (dist[u] < INF) {
				if (u == e)
					return dist[u];
				for (Edge ed : G[u].adj) {
					int v = ed.to, w = ed.w;
					if (dist[u] + w < dist[v]) {
						dist[v] = dist[u] + w;
						p[v] = u;
						Q.offer(new QueueItem(v, dist[v]));
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			N = in.nextInt();
			if (N == 0) break;
			
			G = new Vertex[N];
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex();
			
			for (int from = 0; from < N; ++from) {
				int M = in.nextInt();
				for (int j = 0; j < M; ++j) {
					int to = in.nextInt() - 1;
					int w = in.nextInt();
					G[from].adj.add(new Edge(to, w));
				}
			}
			int s = in.nextInt() - 1;
			int e = in.nextInt() - 1;
			
			int dist = dijkstra(s, e);
			Stack<Integer> path = new Stack<Integer>();
			int cur = e;
			while (cur != -1) {
				path.add(cur);
				cur = p[cur];
			}
			System.out.print("Case " + t + ": Path =");
			while (!path.isEmpty())
				System.out.print(" " + (path.pop() + 1));
			System.out.println("; " + dist + " second delay");

			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
