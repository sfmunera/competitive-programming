package bapc;

import java.util.*;
import java.io.*;

public class BAPC13F_FlyingSafely {
	
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
	
	static int N;

	static UnionFind uf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			uf = new UnionFind(N);

			int ans = 0;
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(stk.nextToken()) - 1;
				int b = Integer.parseInt(stk.nextToken()) - 1;
				if (!uf.isSameSet(a, b)) {
					++ans;
					uf.merge(a, b);
				}
			}
			
			System.out.println(ans);
		}
		
		in.close();
	}
}
