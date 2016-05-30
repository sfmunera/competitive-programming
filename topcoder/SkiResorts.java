
import java.util.*;

public class SkiResorts {
	
	String[] adj;
	int[] h;
	
	final long INF = Long.MAX_VALUE / 3;
	
	class QueueItem implements Comparable<QueueItem> {
		int u;
		int h;
		long d;
		public QueueItem(int u, int h, long d) {
			this.u = u; this.h = h; this.d = d;
		}
		
		public int compareTo(QueueItem q) {
			if (this.d > q.d) return 1;
			if (this.d < q.d) return -1;
			return 0;
		}
	}
	
	long dijkstra() {
		int N = h.length;
		long[][] dist = new long[N][N];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		for (int i = 0; i < N; ++i)
			Arrays.fill(dist[i], INF);
		
		for (int i = 0; i < N; ++i) {
			dist[0][i] = Math.abs(h[0] - h[i]);
			Q.offer(new QueueItem(0, i, dist[0][i]));
		}
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			long d = q.d;
			int he = q.h;
			
			if (d == dist[u][he]) {
				for (int v = 0; v < N; ++v)
					if (adj[u].charAt(v) == 'Y') {
						for (int i = 0; i < N; ++i) {
							long w = Math.abs(h[i] - h[v]);
							if (dist[u][he] + w < dist[v][i] && h[he] >= h[i]) {
								dist[v][i] = dist[u][he] + w;
								Q.offer(new QueueItem(v, i, dist[v][i]));
							}
						}
					}
			}
		}
		
		long ans = INF;
		for (int i = 0; i < N; ++i)
			ans = Math.min(ans, dist[N - 1][i]);
		return ans == INF ? -1 : ans;
	}
	
    public long minCost(String[] road, int[] altitude) {
        adj = road;
        h = altitude;
        
        return dijkstra();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SkiResorts.class, "test.*");
    }

	public void test0() {
		RETester.eq(minCost(new String[] {
			"NYN",
			"YNY",
			"NYN"},
			new int[] {30, 20, 10}), 0L);
	}

	public void test1() {
		RETester.eq(minCost(new String[] {
			"NY",
			"YN"},
			new int[] {10, 20}), 10L);
	}

	public void test2() {
		RETester.eq(minCost(new String[] {
			"NYN",
			"YNN",
			"NNN"},
			new int[] {573, 573, 573}), -1L);
	}

	public void test3() {
		RETester.eq(minCost(new String[] {
			"NNYNNYYYNN",
			"NNNNYNYNNN",
			"YNNNNYYNNN",
			"NNNNNNYNYY",
			"NYNNNNNNYY",
			"YNYNNNNYNN",
			"YYYYNNNYNN",
			"YNNNNYYNNN",
			"NNNYYNNNNN",
			"NNNYYNNNNN"},
			new int[] {7, 4, 13, 2, 8, 1, 8, 15, 5, 15}), 12L);
	}

// END CUT HERE
}
