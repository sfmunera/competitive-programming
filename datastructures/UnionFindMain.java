package datastructures;

import java.io.*;
import java.util.*;

public class UnionFindMain {
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
	
	// Problem UVa 11503: Virtual friends
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int F = Integer.parseInt(in.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			String[][] relations = new String[F][2];
			int ind = 0;
			for (int i = 0; i < F; ++i) {
				relations[i] = in.readLine().split("[ ]+");
				if (!map.containsKey(relations[i][0]))
					map.put(relations[i][0], ind++);
				if (!map.containsKey(relations[i][1]))
					map.put(relations[i][1], ind++);
			}
			
			int N = map.size();
			UnionFind uf = new UnionFind(N);

			for (int i = 0; i < F; ++i) {
				int id1 = map.get(relations[i][0]);
				int id2 = map.get(relations[i][1]);
				uf.merge(id1, id2);
				System.out.println(uf.setSize(id1));
			}
		}
		
		in.close();
		System.exit(0);
	}
}
