package uva;

import java.util.*;
import java.io.*;

public class UVa11492_Babel {
	
	static final int INF = (int) 1e9;
	
	static ArrayList<ArrayList<Edge>> G;
	
	static class Edge {
		int to;
		char c;
		int len;
		public Edge(int to, char c, int len) {
			this.to = to;
			this.c = c;
			this.len = len;
		}
		public String toString() {
			return "<" + to + "," + c + "," + len + ">";
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		int u;
		char c;
		int d;
		public QueueItem(int u, char c, int d) {
			this.u = u;
			this.c = c;
			this.d = d;
		}
		@Override
		public int compareTo(QueueItem q) {
			return this.d - q.d;
		}
	}
	
	static int dijkstra(int s, int t) {
		int N = G.size();
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		int[][] dist = new int[N][30];
		
		for (int i = 0; i < N; ++i)
			Arrays.fill(dist[i], INF);
		
		Q.offer(new QueueItem(s, (char)('z' + 1), 0));
		Arrays.fill(dist[s], 0);
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u; char c = q.c; int d = q.d;
			
			if (d > dist[u][c - 'a']) continue;
			for (Edge e : G.get(u)) {
				int v = e.to; int len = e.len; char nc = e.c;
				if (nc != c && dist[u][c - 'a'] + len < dist[v][nc - 'a']) {
					dist[v][nc - 'a'] = dist[u][c - 'a'] + len;
					Q.offer(new QueueItem(v, nc, dist[v][nc - 'a']));
				}
			}
		}
		
		int ans = INF;
		for (int i = 0; i < 26; ++i)
			ans = Math.min(ans, dist[t][i]);
		return ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int M = in.nextInt();
			if (M == 0)
				break;
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int cnt = 0;
			G = new ArrayList<ArrayList<Edge>>();
			
			String start = in.next();
			String end = in.next();
			
			if (!map.containsKey(start)) {
				map.put(start, cnt++);
				G.add(new ArrayList<Edge>());
			}
			if (!map.containsKey(end)) {
				map.put(end, cnt++);
				G.add(new ArrayList<Edge>());
			}
			for (int i = 0; i < M; ++i) {
				String l1 = in.next();
				String l2 = in.next();
				String w = in.next();
				
				if (!map.containsKey(l1)) {
					map.put(l1, cnt++);
					G.add(new ArrayList<Edge>());
				}
				if (!map.containsKey(l2)) {
					map.put(l2, cnt++);
					G.add(new ArrayList<Edge>());
				}
				
				int u = map.get(l1);
				int v = map.get(l2);
				
				G.get(u).add(new Edge(v, w.charAt(0), w.length()));
				G.get(v).add(new Edge(u, w.charAt(0), w.length()));
			}
			int min = dijkstra(map.get(start), map.get(end));

			sb.append((min == INF ? "impossivel" : min) + "\n");
		}
		System.out.print(sb);
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
