package livearchive;

import java.io.*;
import java.util.*;

public class CrashAndGorelians {
	
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
	
	static class Gorelian {
		double x, y, r;
		public Gorelian(double x, double y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
		
		public String toString() {
			return "(" + x + ", " + y + ", " + r + ")";
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		while (true) {
			int N = in.nextInt();
			if (N == 0) break;
			
			Gorelian[] gorelians = new Gorelian[N];
			
			for (int i = 0; i < N; ++i) {
				double x = in.nextInt();
				double y = in.nextInt();
				double r = in.nextInt();
				
				gorelians[i] = new Gorelian(x, y, r);
			}
			
			UnionFind uf = new UnionFind(N);
			for (int i = 1; i < N; ++i) {
				boolean changed = true;
				while (changed) {
					changed = false;
					ArrayList<Integer> reachable = new ArrayList<Integer>();
					for (int j = 0; j < i; ++j) {
						double dx = gorelians[i].x - gorelians[j].x;
						double dy = gorelians[i].y - gorelians[j].y;
						double dist = dx * dx + dy * dy;
						
						double max = Math.max(gorelians[i].r, gorelians[j].r);
						if (dist <= max * max && !uf.isSameSet(i, j))
							reachable.add(j);
					}
					
					double mx = gorelians[i].x;
					double my = gorelians[i].y;
					double mr = gorelians[i].r * gorelians[i].r;
					
					for (int j : reachable) {
						mx += gorelians[j].x;
						my += gorelians[j].y;
						mr += gorelians[j].r * gorelians[j].r;
						uf.merge(i, j);
						changed = true;
					}
					
					mx /= (reachable.size() + 1);
					my /= (reachable.size() + 1);
					mr = Math.sqrt(mr);

					for (int j = 0; j <= i; ++j) {
						if (uf.isSameSet(i, j)) {
							gorelians[j].x = mx;
							gorelians[j].y = my;
							gorelians[j].r = mr;
						}
					}
				}
				//System.out.println(Arrays.toString(gorelians));
			}
			
			System.out.println(uf.sets);
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
