package uva;

import java.util.*;
import java.io.*;

public class UVa00658_ItsnotaBugItsaFeature {
	
	static final int INF = (int) 1e9;
	
	static class QueueItem implements Comparable<QueueItem> {
		int u, d;
		public QueueItem(int u, int d) {
			this.u = u;
			this.d = d;
		}
		public int compareTo(QueueItem q) {
			return this.d - q.d;
		}
	}

	static int dijkstra(int N, int[] cost,
			String[] precondition, String[] patch) {
		
		int M = cost.length;
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		int[] dist = new int[1 << N];
		
		Arrays.fill(dist, INF);
		
		int initialState = (1 << N) - 1;
		dist[initialState] = 0;
		Q.offer(new QueueItem(initialState, 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int u = q.u;
			int d = q.d;
			if (d == dist[u]) {
				if (u == 0)
					return d;
				for (int i = 0; i < M; ++i) {
					boolean ok = true;
					for (int j = 0; j < N; ++j)
						if ((precondition[i].charAt(j) == '+' && (u & (1 << j)) == 0) ||
							(precondition[i].charAt(j) == '-' && (u & (1 << j)) > 0)) {
							ok = false;
							break;
						}
					
					if (!ok) continue;
					int next = u;
					for (int j = 0; j < N; ++j)
						if (patch[i].charAt(j) == '+')
							next |= (1 << j);
						else if (patch[i].charAt(j) == '-')
							next &= ~(1 << j);
					
					if (dist[next] > dist[u] + cost[i]) {
						dist[next] = dist[u] + cost[i];
						Q.offer(new QueueItem(next, dist[next]));
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int t = 1;
		while (true) {
			int N = in.nextInt();
			int M = in.nextInt();
			
			if (N == 0 && M == 0)
				break;
			
			int[] cost = new int[M];
			String[] precondition = new String[M];
			String[] patch = new String[M];
			
			for (int i = 0; i < M; ++i) {
				cost[i] = in.nextInt();
				precondition[i] = in.next();
				patch[i] = in.next();
			}
			
			int ans = dijkstra(N, cost, precondition, patch);
			System.out.println("Product " + t++);
			System.out.println(ans == -1 ? "Bugs cannot be fixed." : "Fastest sequence takes " + ans + " seconds.");
			System.out.println();
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
