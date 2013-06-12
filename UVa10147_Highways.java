package uva;

import java.io.*;
import java.util.*;

public class UVa10147_Highways {

	static class UnionFind {
		private int[] p;
		private int[] rank;
		private int[] size;
		private int sets;
		private int N;
		
		public UnionFind(int _N) {
			N = _N;
			p = new int[N];
			rank = new int[N];
			size = new int[N];
			sets = N;
			
			for (int i = 0; i < N; ++i) {
				p[i] = i;
				rank[i] = 0;
				size[i] = 1;
			}
		}
		public int find(int u) {
			return p[u] == u ? u : (p[u] = find(p[u]));
		}
		public void merge(int u, int v) {
			int pu = find(u);
			int pv = find(v);
			if (pu == pv) return;
			if (rank[pu] < rank[pv]) {
				size[pv] += size[pu];
				p[pu] = pv;
			} else {
				size[pu] += size[pv];
				p[pv] = pu;
			}
			if (rank[pu] == rank[pv])
				++rank[pu];
			--sets;
		}
		public boolean isSameSet(int u, int v) {
			return find(u) == find(v);
		}
		public int setSize(int u) {
			return size[find(u)];
		}
		public int sets() {
			return sets;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
	
	
	static ArrayList<Edge> edges;
	static UnionFind uf;
	
	static boolean kruskal() {
		Collections.sort(edges);
		
		boolean ok = false;
		
		for (Edge e : edges) {
			int u = e.u;
			int v = e.v;
			if (!uf.isSameSet(u, v)) {
				ok = true;
				uf.merge(u, v);
				System.out.println((u + 1) + " " + (v + 1));
			}
		}
		
		return ok;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		boolean first = true;
		while (T-- > 0) {
			int N = in.nextInt();
			int[] x = new int[N];
			int[] y = new int[N];
			
			uf = new UnionFind(N);
			edges = new ArrayList<Edge>();
						
			for (int i = 0; i < N; ++i) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}
			
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j) {
					int dist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
					edges.add(new Edge(i, j, dist));
				}
					
			int M = in.nextInt();
			for (int i = 0; i < M; ++i) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				uf.merge(u, v);
			}
			
			if (first) first = false; else System.out.println();
			
			boolean ok = kruskal();
			if (!ok)
				System.out.println("No new highways need");
			
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
