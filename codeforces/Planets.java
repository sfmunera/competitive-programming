import java.util.*;
import java.io.*;

public class Planets {
	
	static final long INF = Long.MAX_VALUE / 3;
	
	static class Edge {
		int to;
		long w;
		Edge(int to, long w) {
			this.to = to;
			this.w = w;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		int u;
		long t, dist;
		public QueueItem(int u, long t, long dist) {
			this.u = u; this.t = t; this.dist = dist;
		}
		public int compareTo(QueueItem q) {
			if (this.dist < q.dist) return -1;
			if (this.dist > q.dist) return 1;
			return 0;
		}
	}
	
	static long findNext(long t, List<Long> times) {
		int posT = Collections.binarySearch(times, t);
		if (posT < 0) return t;
		
		int low = 1;
		int high = times.size() - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (posT + mid >= times.size()) {
				high = mid - 1;
			} else if (times.get(posT + mid) == t + mid) {
				low = mid + 1;
			} else {
				ans = mid;
				high = mid - 1;
			}
		}
		return ans == -1 ? times.get(times.size() - 1) + 1 : t + ans;
	}
	
	static long dijkstra(List<List<Edge>> graph, Map<Integer, List<Long>> times) {
		int N = graph.size();
		long[] dist = new long[N];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		Arrays.fill(dist, INF);
		dist[0] = 0;
		Q.offer(new QueueItem(0, 0, 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			long t = q.t;
			long d = q.dist;
			if (d == dist[u])
				for (Edge e : graph.get(u)) {
					int v = e.to;
					long w = e.w;
					long nt = findNext(t, times.get(u));
					if (dist[u] + w + nt - t < dist[v]) {
						dist[v] = dist[u] + w + nt - t;
						Q.offer(new QueueItem(v, nt + w, dist[v]));
					}
				}
		}
		return dist[N - 1] == INF ? -1 : dist[N - 1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) graph.add(new ArrayList<Edge>());
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(stk.nextToken()) - 1;
			int b = Integer.parseInt(stk.nextToken()) - 1;
			long c = Long.parseLong(stk.nextToken());
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
		Map<Integer, List<Long>> times = new HashMap<>();
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(stk.nextToken());
			List<Long> tmp = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				long t = Long.parseLong(stk.nextToken());
				tmp.add(t);
			}
			times.put(i, tmp);
		}		
		System.out.println(dijkstra(graph, times));
		
		in.close();
		System.exit(0);
	}
}
