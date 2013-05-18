package uva;

import java.util.*;
import java.io.*;

public class UVa01112_MiceandMaze {
	
	static final long INF = Long.MAX_VALUE / 3;
	
	static class QueueItem implements Comparable<QueueItem> {
		int u;
		long w;
		public QueueItem(int u, long w) {
			this.u = u;
			this.w = w;
		}
		public int compareTo(QueueItem q) {
			if (this.w < q.w) return -1;
			if (this.w > q.w) return 1;
			return 0;
		}
	}
	
	static long[] dijkstra(int s, long[][] adj, int N) {
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		long[] d = new long[N];
		
		Arrays.fill(d, INF);
		d[s] = 0;
		Q.offer(new QueueItem(s, 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			long w = q.w;
			if (w == d[u]) {
				for (int v = 0; v < N; ++v)
					if (adj[u][v] >= 0 && d[u] + adj[u][v] < d[v]) {
						d[v] = d[u] + adj[u][v];
						Q.offer(new QueueItem(v, d[v]));
					}
			}
		}
		return d;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int K = in.nextInt();
		boolean first = true;
		while (K-- > 0) {
			int N = in.nextInt();
			int E = in.nextInt();
			long T = in.nextLong();
			int M = in.nextInt();
			
			long[][] adj = new long[N][N];
			for (int i = 0; i < N; ++i)
				Arrays.fill(adj[i], -1);
			
			for (int i = 0; i < M; ++i) {
				int from = in.nextInt();
				int to = in.nextInt();
				long length = in.nextLong();
				adj[to - 1][from - 1] = length;
			}
			
			long[] d = dijkstra(E - 1, adj, N);
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				if (d[i] <= T)
					++cnt;
			
			if (first) first = false; else System.out.println();
			System.out.println(cnt);
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}
