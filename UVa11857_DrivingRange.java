package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2957 (11857 - Driving Range) */
/* SUBMISSION: 10359705 */
/* SUBMISSION TIME: 2012-07-19 21:28:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11857_DrivingRange {
	
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
	
	static int kruskal() {
		int max = -1;
		Collections.sort(edgeList);
		Set<Integer> vertices = new HashSet<Integer>();
		initSet(N);
		for (Edge e : edgeList)
			if (!isSameSet(e.u, e.v)) {
				unionSet(e.u, e.v);
				vertices.add(e.u);
				vertices.add(e.v);
				max = Math.max(max, e.w);
			}
		if (vertices.size() != N)
			return -1;
		return max;
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
				int w = Integer.parseInt(parts[2]);
				edgeList.add(new Edge(u, v, w));
			}
			int ans = kruskal();
			System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
		}
		
		in.close();
		System.exit(0);
	}
}
