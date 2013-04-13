package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3649 (1208 - Oreon) */
/* SUBMISSION: 10359599 */
/* SUBMISSION TIME: 2012-07-19 20:49:16 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01208_Oreon {
	
	static int[] pset;
	static int[] rank;
	static List<Edge> edgeList;
	static int N;
	
	static class Edge implements Comparable<Edge> {
		int u, v, w;
		
		public Edge(int u, int v, int w) {
			this.u = u; this.v = v; this.w = w;
		}

		public int compareTo(Edge e) {
			if (this.w != e.w)
				return this.w - e.w;
			if (this.u != e.u)
				return this.u - e.u;
			return this.v - e.v;
		}
		
		public String toString() {
			return (char)(this.u + 'A') + "-" + (char)(this.v + 'A') + " " + this.w;
		}
	}
	
	static void initSet(int N) {
		pset = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; ++i) {
			pset[i] = i;
			rank[i] = 0;
		}
	}
	
	static int findSet(int i) {
		return (pset[i] == i) ? i : (pset[i] = findSet(pset[i]));
	}
	
	static boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	static void unionSet(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		if (rank[pi] > rank[pj])
			pset[pj] = pi;
		else
			pset[pi] = pj;
		if (rank[pi] == rank[pj])
			++rank[pj];
	}
	
	static List<Edge> kruskal() {
		List<Edge> mst = new ArrayList<Edge>();
		Collections.sort(edgeList);
		initSet(N);
		for (Edge e : edgeList)
			if (!isSameSet(e.u, e.v)) {
				unionSet(e.u, e.v);
				mst.add(e);
			}
		Collections.sort(mst);
		return mst;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(in.readLine());
			edgeList = new ArrayList<Edge>();
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ,]+");
				for (int j = i + 1; j < N; ++j) {
					int w = Integer.parseInt(parts[j]);
					if (w > 0)
						edgeList.add(new Edge(i, j, w));
				}
			}
			List<Edge> mst = kruskal();
			System.out.println("Case " + t + ":");
			for (Edge e : mst)
				System.out.println(e);
		}
		
		in.close();
		System.exit(0);
	}
}
