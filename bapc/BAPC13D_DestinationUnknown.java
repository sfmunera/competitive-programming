package bapc;

import java.util.*;

public class BAPC13D_DestinationUnknown {
	
	static final int INF = (int) 1e9;
	
	static class Edge implements Comparable<Edge> {
		int from, to, d;
		Edge(int from, int to, int d) {
			this.from = from;
			this.to = to;
			this.d = d;
		}
		@Override
		public int compareTo(Edge that) {
			return this.d - that.d;
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

	static int[] dijkstra(int s, List<List<Edge>> graph) {
		int N = graph.size();
		int[] dist = new int[N];
		int[] p = new int[N];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();

		Arrays.fill(dist, INF);
		Arrays.fill(p, -1);
		dist[s] = 0;
		Q.offer(new QueueItem(s, 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u, d = q.dist;
			if (d == dist[u]) {
				for (Edge e : graph.get(u)) {
					int v = e.to, w = e.d;
					if (dist[u] + w < dist[v]) {
						dist[v] = dist[u] + w;
						p[v] = u;
						Q.offer(new QueueItem(v, dist[v]));
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int t = in.nextInt();
			
			int s = in.nextInt() - 1;
			int g = in.nextInt() - 1;
			int h = in.nextInt() - 1;
			
			List<List<Edge>> graph = new ArrayList<List<Edge>>();
			
			for (int i = 0; i < n; ++i) {
				graph.add(new ArrayList<Edge>());
			}
			
			int smellyLength = 0;
			for (int i = 0; i < m; ++i) {
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				int d = in.nextInt();
				
				graph.get(a).add(new Edge(a, b, d));
				graph.get(b).add(new Edge(b, a, d));
				
				if ((a == g && b == h) || (a == h && b == g)) {
					smellyLength = d;
				}
			}
			
			int[] distOrigin = dijkstra(s, graph);
			int[] distg = dijkstra(g, graph);
			int[] disth = dijkstra(h, graph);
			
			List<Integer> ans = new ArrayList<Integer>();
			for (int i = 0; i < t; ++i) {
				int to = in.nextInt() - 1;
				
				if ((distOrigin[g] + smellyLength + disth[to] == distOrigin[to]) ||
					(distOrigin[h] + smellyLength + distg[to] == distOrigin[to])) {
					ans.add(to + 1);
				}
			}
			Collections.sort(ans);
			for (int i = 0; i < ans.size(); ++i) {
				if (i > 0) System.out.print(" ");
				System.out.print(ans.get(i));
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
