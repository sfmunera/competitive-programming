package codeforces;

import java.util.*;
import java.io.*;

public class PashmakAndGraph {

	static class Edge implements Comparable<Edge> {
		int from, to, w;
		Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge that) {
			if (this.w != that.w) return this.w - that.w;
			if (this.from != that.from) return this.from - that.from;
			return this.to - that.to;
		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		List<Edge> graph = new ArrayList<Edge>();
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			int w = in.nextInt();
			
			graph.add(new Edge(u, v, w));
		}
		
		Collections.sort(graph);
		
		int[] dp = new int[n];
		int[] tmp = new int[n];
		
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			int w = graph.get(i).w;
			
			int j = i;
			while (j < m && graph.get(j).w == w) ++j;
			
			for (int k = i; k < j; ++k) {
				Edge e = graph.get(k);
				tmp[e.to] = 0;
			}
			for (int k = i; k < j; ++k) {
				Edge e = graph.get(k);
				tmp[e.to] = Math.max(tmp[e.to], 1 + dp[e.from]);
			}
			
			for (int k = i; k < j; ++k) {
				Edge e = graph.get(k);
				dp[e.to] = Math.max(dp[e.to], tmp[e.to]);
				ans = Math.max(ans, dp[e.to]);
			}
			i = j - 1;
		}
		
		
		System.out.println(ans);
		
		System.exit(0);
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
