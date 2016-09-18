package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2169 (11228 - Transportation system.) */
/* SUBMISSION: 10929563 */
/* SUBMISSION TIME: 2012-11-24 02:17:09 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11228_Transportationsystem {
	
	static List<Edge> edgeList;
	static int N, R;

	static int find(int[] pset, int i) {
		return pset[i] == i ? i : (pset[i] = find(pset, pset[i]));
	}
	
	static boolean isSameSet(int[] pset, int i, int j) {
		return find(pset, i) == find(pset, j);
	}
	
	static void merge(int[] pset, int[] rank, int i, int j) {
		int pi = find(pset, i);
		int pj = find(pset, j);
		if (rank[pi] > rank[pj])
			pset[pj] = pi;
		else
			pset[pi] = pj;
		if (rank[pi] == rank[pj])
			++rank[pj];
	}
	
	static class Edge implements Comparable<Edge> {
		int u, v, d2;
		public Edge(int u, int v, int d2) {
			this.u = u; this.v = v; this.d2 = d2;
		}

		public int compareTo(Edge e) {
			return this.d2 - e.d2;
		}
	}
	
	static long[] kruskal() {
		int[] pset = new int[N];
		int[] pset2 = new int[N];
		int[] rank = new int[N];
		int[] rank2 = new int[N];

		for (int i = 0; i < N; ++i) {
			pset[i] = i;
			rank[i] = 0;
			pset2[i] = i;
			rank2[i] = 0;
		}
		
		Collections.sort(edgeList);
		double roadCost = 0.0;
		double railCost = 0.0;
		for (Edge e : edgeList) {
			int u = e.u, v = e.v, d2 = e.d2;
			if (!isSameSet(pset, u, v)) {
				merge(pset, rank, u, v);
				if (d2 <= R * R) {
					merge(pset2, rank2, u, v);
					roadCost += Math.sqrt(d2);
				} else
					railCost += Math.sqrt(d2);
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; ++i)
			set.add(find(pset2, i));
		return new long[]{(long)set.size(), Math.round(roadCost), Math.round(railCost)};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			R = Integer.parseInt(parts[1]);
			
			int[] x = new int[N];
			int[] y = new int[N];
			
			for (int i = 0; i < N; ++i) {
				parts = in.readLine().split("[ ]+");
				x[i] = Integer.parseInt(parts[0]);
				y[i] = Integer.parseInt(parts[1]);
			}
			
			edgeList = new ArrayList<Edge>();
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j) {
					int d2 = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
					edgeList.add(new Edge(i, j, d2));
				}
			long[] ans = kruskal();
			System.out.println("Case #" + t + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
		}
		
		in.close();
		System.exit(0);
	}
}
