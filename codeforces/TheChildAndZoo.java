package codeforces;

import java.io.*;
import java.util.*;

public class TheChildAndZoo {
	
	static class UnionFind {
		int[] p, rank, size;
		int sets, N;

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
		int find(int u) {
			return p[u] == u ? u : (p[u] = find(p[u]));
		}
		void merge(int u, int v) {
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
		boolean isSameSet(int u, int v) {
			return find(u) == find(v);
		}
		int getSize(int u) {
			return size[find(u)];
		}
		int sets() {
			return sets;
		}
	}
	
	static class Node implements Comparable<Node> {
		long a; int idx;
		List<Node> adj;
		Node(long a, int idx) {
			this.a = a;
			this.idx = idx;
			this.adj = new ArrayList<Node>();
		}
		@Override
		public int compareTo(Node that) {
			if (this.a != that.a) return (int)(that.a - this.a);
			return this.idx - that.idx;
		}
		@Override
		public String toString() {
			return "v[" + idx + "] = " + a;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		List<Node> graph = new ArrayList<Node>();
		
		for (int i = 0; i < n; ++i) {
			long a = in.nextLong();
			graph.add(new Node(a, i));
		}
		
		for (int i = 0; i < m; ++i) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			graph.get(x).adj.add(graph.get(y));
			graph.get(y).adj.add(graph.get(x));
		}
		
		Collections.sort(graph);
		
		long total = 0;
		boolean[] seen = new boolean[n];
		UnionFind uf = new UnionFind(n);
		
		// count paths reachable from u, and passing through u
		for (Node u : graph) {
			for (Node v : u.adj)
				if (seen[v.idx] && !uf.isSameSet(u.idx, v.idx)) {
					total += u.a * uf.getSize(u.idx) * uf.getSize(v.idx);
					uf.merge(u.idx, v.idx);
				}

			seen[u.idx] = true;
		}
		
		long numPairs = (long) n * (n - 1) / 2;
		double ans = (double) total / numPairs;

		System.out.printf("%.6f\n", ans);
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
