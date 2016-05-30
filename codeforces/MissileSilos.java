package codeforces;

import java.io.*;
import java.util.*;

public class MissileSilos {
	
	static final int INF = (int) 1e9;
	
	static class Edge {
		int to, cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		int u, dist;
		public QueueItem(int u, int dist) {
			this.u = u;
			this.dist = dist;
		}
		@Override
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}
	
	static int dijkstra(int s, int n, int l, ArrayList<ArrayList<Edge>> G) {
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		int[] dist = new int[n];
		int[] p = new int[n];
		int ans = 0;
		
		Arrays.fill(dist, INF);
		Arrays.fill(p, -1);
		dist[s] = 0;
		Q.offer(new QueueItem(s, 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			int d = q.dist;
			
			if (d > dist[u]) continue;
			for (Edge e : G.get(u)) {
				int v = e.to;
				int w = e.cost;
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					p[v] = u;
					Q.offer(new QueueItem(v, dist[v]));
				}
			}
		}
		
		for (int u = 0; u < n; ++u) {
			if (dist[u] == l)
				++ans;
			for (Edge e : G.get(u)) {
				int v = e.to;
				int w = e.cost;
				if (v <= u) continue;
				if (l > dist[u] && l > dist[v] && dist[v] + dist[u] + w == 2 * l)
					++ans;
				if (l > dist[u] && l < dist[u] + w && l < dist[v] + w - (l - dist[u]))
					++ans;
				if (l > dist[v] && l < dist[v] + w && l < dist[u] + w - (l - dist[v]))
					++ans;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt() - 1;
		
		ArrayList<ArrayList<Edge>> G = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < n; ++i)
			G.add(new ArrayList<Edge>());
		
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			int w = in.nextInt();
			
			G.get(u).add(new Edge(v, w));
			G.get(v).add(new Edge(u, w));
		}
		
		int l = in.nextInt();
		
		int ans = dijkstra(s, n, l, G);
		System.out.println(ans);
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}
