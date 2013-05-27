package uva;

import java.util.*;
import java.io.*;

public class UVa12135_SwitchBulbs {
	
	static int[] bfs(int N, int[] switches) {
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean[] seen = new boolean[1 << N];
		int[] dist = new int[1 << N];
		
		Arrays.fill(dist, -1);
		
		seen[0] = true;
		dist[0] = 0;
		Q.offer(0);
		
		while (!Q.isEmpty()) {
			int x = Q.poll();
			for (int i = 0; i < switches.length; ++i) {
				int next = x ^ switches[i];
				if (!seen[next]) {
					seen[next] = true;
					dist[next] = dist[x] + 1;
					Q.offer(next);
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			int M = in.nextInt();
			
			int[] switches = new int[M];
			for (int i = 0; i < M; ++i) {
				int k = in.nextInt();
				for (int j = 0; j < k; ++j)
					switches[i] |= (1 << in.nextInt());
			}
			
			int[] dist = bfs(N, switches);
			
			int q = in.nextInt();
			System.out.println("Case " + t + ":");
			for (int i = 0; i < q; ++i) {
				int target = Integer.parseInt(in.next(), 2);
				System.out.println(dist[target]);
			}
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
