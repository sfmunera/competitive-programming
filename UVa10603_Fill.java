package uva;

import java.io.*;
import java.util.*;

public class UVa10603_Fill {
	static final int INF = (int) 1e9;
	static int[] capacities;
	static int D;
	static int[][][] dist;
	static int[] minimum;
	
	static class QueueItem implements Comparable<QueueItem> {
		int a, b, c;
		int dist;
		
		public QueueItem(int a, int b, int c, int dist) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}
	
	static void dijkstra() {
		dist = new int[capacities[0] + 1][capacities[1] + 1][capacities[2] + 1];
		minimum = new int[Math.max(capacities[0], Math.max(capacities[1], capacities[2])) + 1];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		for (int i = 0; i <= capacities[0]; ++i)
			for (int j = 0; j <= capacities[1]; ++j)
				for (int k = 0; k <= capacities[2]; ++k)
					dist[i][j][k] = INF;
		
		Arrays.fill(minimum, INF);
		
		dist[0][0][capacities[2]] = 0;
		Q.offer(new QueueItem(0, 0, capacities[2], 0));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int[] current = new int[3];
			current[0] = q.a;
			current[1] = q.b;
			current[2] = q.c;
			int d = q.dist;
			
			for (int k = 0; k < 3; ++k)
				minimum[current[k]] = Math.min(minimum[current[k]], d);
			
			if (d > dist[current[0]][current[1]][current[2]]) continue;

			// Pour from i to j
			for (int i = 0; i < 3; ++i)
				for (int j = 0; j < 3; ++j) {
					if (i == j) continue;
					int w = Math.min(current[i], capacities[j] - current[j]);
					int[] next = new int[3];
					for (int k = 0; k < 3; ++k)
						next[k] = current[k];
					next[i] -= w;
					next[j] += w;
					if (dist[current[0]][current[1]][current[2]] + w < dist[next[0]][next[1]][next[2]]) {
						dist[next[0]][next[1]][next[2]] = dist[current[0]][current[1]][current[2]] + w;
						Q.offer(new QueueItem(next[0], next[1], next[2], dist[next[0]][next[1]][next[2]]));
					}
				}
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			capacities = new int[3];
			capacities[0] = in.nextInt();
			capacities[1] = in.nextInt();
			capacities[2] = in.nextInt();
			D = in.nextInt();
			
			dijkstra();
			
			int least = 0;
			int d = 0;
			for (int i = D; i >= 0; --i)
				if (minimum[i] < INF) {
					least = minimum[i];
					d = i;
					break;
				}
			System.out.println(least + " " + d);
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
