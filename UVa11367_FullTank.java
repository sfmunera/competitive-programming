package uva;

import java.util.*;
import java.io.*;

public class UVa11367_FullTank {
	
	static final int INF = (int) 1e9;
	static ArrayList<ArrayList<Edge>> G;
	static int[] prices;
	static int n;
	
	static class Edge {
		int to, dist;
		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		int u, cap, fuel;
		public QueueItem(int u, int cap, int fuel) {
			this.u = u;
			this.cap = cap;
			this.fuel = fuel;
		}
		@Override
		public int compareTo(QueueItem q) {
			return this.fuel - q.fuel;
		}
	}
	
	static int dijkstra(int c, int s, int e) {
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		int[][] fuel = new int[n][c + 1];
		
		for (int i = 0; i < n; ++i)
			Arrays.fill(fuel[i], INF);
		
		fuel[s][0] = 0;
		Q.offer(new QueueItem(s, 0, 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			int f = q.fuel;
			int cap = q.cap;
			
			if (f > fuel[u][cap]) continue;
			if (u == e) return f;
			for (Edge edge : G.get(u)) {
				int v = edge.to;
				int dist = edge.dist;
				if (cap >= dist && fuel[u][cap] < fuel[v][cap - dist]) {
					fuel[v][cap - dist] = fuel[u][cap];
					Q.offer(new QueueItem(v, cap - dist, fuel[v][cap - dist]));
				}
			}
			
			if (cap < c && fuel[u][cap] + prices[u] < fuel[u][cap + 1]) {
				fuel[u][cap + 1] = fuel[u][cap] + prices[u];
				Q.offer(new QueueItem(u, cap + 1, fuel[u][cap + 1]));
			}
		}
		
		return INF;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		int m = in.nextInt();
		 
		G = new ArrayList<ArrayList<Edge>>();
		prices = new int[n];
		for (int i = 0; i < n; ++i) {
			prices[i] = in.nextInt();
			G.add(new ArrayList<Edge>());
		}	
		 	
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt();
			int v = in.nextInt();
			int d = in.nextInt();
			G.get(u).add(new Edge(v, d));
			G.get(v).add(new Edge(u, d));
		}
		 
		int q = in.nextInt();
		for (int i = 0; i < q; ++i) {
			int c = in.nextInt();
			int s = in.nextInt();
			int e = in.nextInt();
			 
			int ans = dijkstra(c, s, e);
			System.out.println(ans == INF ? "impossible" : ans);
		}
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
