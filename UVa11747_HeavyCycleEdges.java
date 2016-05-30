package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2847 (11747 - Heavy Cycle Edges) */
/* SUBMISSION: 10929691 */
/* SUBMISSION TIME: 2012-11-24 03:13:19 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11747_HeavyCycleEdges {
	
	static int[] pset, rank;
	static List<Edge> edgeList;
	static int N;

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
		int u, v;
		long w;
		public Edge(int u, int v, long w) {
			this.u = u; this.v = v; this.w = w;
		}

		public int compareTo(Edge e) {
			return (int)(this.w - e.w);
		}
	}
	
	static ArrayList<Long> kruskal() {
		pset = new int[N];
		rank = new int[N];
		ArrayList<Long> heavy = new ArrayList<Long>();

		for (int i = 0; i < N; ++i) {
			pset[i] = i;
			rank[i] = 0;
		}
		
		Collections.sort(edgeList);
		for (Edge e : edgeList) {
			int u = e.u, v = e.v;
			long w = e.w;
			if (!isSameSet(u, v))
				merge(u, v);
			else
				heavy.add(w);
		}
		return heavy;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			if (N == 0 && M == 0) break;
			
			edgeList = new ArrayList<Edge>();
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]);
				int v = Integer.parseInt(parts[1]);
				long w = Long.parseLong(parts[2]);
				edgeList.add(new Edge(u, v, w));
			}
			
			ArrayList<Long> heavy = kruskal();
			
			if (heavy.isEmpty())
				System.out.println("forest");
			else {
				for (int i = 0; i < heavy.size(); ++i) {
					if (i > 0) System.out.print(" ");
					System.out.print(heavy.get(i));
				}
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
