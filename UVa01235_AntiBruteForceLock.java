package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3676 (1235 - Anti Brute Force Lock) */
/* SUBMISSION: 10929924 */
/* SUBMISSION TIME: 2012-11-24 04:56:04 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01235_AntiBruteForceLock {
	
	static int[] pset, rank;
	static List<Edge> edgeList;
	static int N;
	static String[] codes;
	
	static int find(int i) {
		return pset[i] == i ? i : (pset[i] = find(pset[i]));
	}
	
	static boolean isSameSet(int i, int j) {
		return find(i) == find(j);
	}
	
	static void merge(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		if (rank[pi] > rank[pj])
			pset[pj] = pi;
		else
			pset[pi] = pj;
		if (rank[pi] == rank[pj])
			++rank[pj];
	}
	
	static class Edge implements Comparable<Edge> {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u; this.v = v; this.w = w;
		}

		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
	
	static int kruskal() {
		pset = new int[N];
		rank = new int[N];

		for (int i = 0; i < N; ++i) {
			pset[i] = i;
			rank[i] = 0;
		}
		int cost = 0;
		
		Collections.sort(edgeList);
		for (Edge e : edgeList) {
			int u = e.u, v = e.v, w = e.w;
			if (!isSameSet(u, v)) {
				merge(u, v);
				cost += w;
			}
		}
		return cost;
	}
	
	static int cost(String s1, String s2) {
		int cost = 0;
		for (int i = 0; i < 4; ++i) {
			int d1 = s1.charAt(i) - '0';
			int d2 = s2.charAt(i) - '0';
			cost += Math.min(Math.abs(d1 - d2), 10 - Math.abs(d1 - d2));
		}
		return cost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			edgeList = new ArrayList<Edge>();
			
			codes = new String[N];
			for (int i = 1; i <= N; ++i)
				codes[i - 1] = parts[i];
			
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j)
					edgeList.add(new Edge(i, j, cost(codes[i], codes[j])));
			int cost = Integer.MAX_VALUE;
			for (int i = 0; i < N; ++i)
				cost = Math.min(cost, cost("0000", codes[i]));
			System.out.println(cost + kruskal());
		}
		
		in.close();
		System.exit(0);
	}
}
