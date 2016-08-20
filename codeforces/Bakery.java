package codeforces;

import java.io.*;
import java.util.*;

public class Bakery {
	
	static final long INF = (long) 1e15;
	
	static class Edge implements Comparable<Edge> {
		int u, v;
		long l;
		Edge(int u, int v, long l) {
			this.u = u;
			this.v = v;
			this.l = l;
		}
		@Override
		public int compareTo(Edge that) {
			return (int)(this.l - that.l);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		Edge[] edges = new Edge[m];
		for (int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			long l = in.nextLong();
			
			edges[i] = new Edge(u, v, l);
		}
		
		Arrays.sort(edges);
		
		Set<Integer> flour = new HashSet<Integer>();
		for (int i = 0; i < k; ++i) {
			flour.add(in.nextInt() - 1);
		}
		
		long ans = INF;
		for (Edge e : edges) {
			int cnt = 0;
			if (flour.contains(e.u)) ++cnt;
			if (flour.contains(e.v)) ++cnt;
			
			if (cnt != 1) continue;
			ans = e.l;
			break;
		}
		
		System.out.println(ans == INF ? -1 : ans);
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
