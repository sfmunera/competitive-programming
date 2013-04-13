package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 975 (10034 - Freckles) */
/* SUBMISSION: 10267560 */
/* SUBMISSION TIME: 2012-06-28 13:52:31 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10034_Freckles {
	
	static List<Edge> edgeList;
	static int N;
	static int[] pset;
	static int[] rank;

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

	static class Edge implements Comparable<Edge> {
		double w;
		int from;
		int to;

		public Edge(double w, int from, int to) {
			this.w = w;
			this.from = from;
			this.to = to;
		}

		public int compareTo(Edge e) {
			return Double.compare(this.w, e.w);
		}
	}

	static double kruskal() {
		Collections.sort(edgeList);

		double cost = 0;
		initSet(N);
		for (int i = 0; i < edgeList.size(); ++i) {
			Edge e = edgeList.get(i);
			if (!isSameSet(e.from, e.to)) {
				cost += e.w;
				unionSet(e.from, e.to);
			}
		}

		return cost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			N = Integer.parseInt(in.readLine());
			double[] x = new double[N];
			double[] y = new double[N];
			edgeList = new ArrayList<Edge>();
			
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				x[i] = Double.parseDouble(parts[0]);
				y[i] = Double.parseDouble(parts[1]);
			}
			
			for (int i = 0; i < N - 1; ++i)
				for (int j = i + 1; j < N; ++j) {
					double dx = x[i] - x[j];
					double dy = y[i] - y[j];
					double d = Math.sqrt(dx * dx + dy * dy);
					
					edgeList.add(new Edge(d, i, j));
					edgeList.add(new Edge(d, j, i));
				}
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.printf(Locale.ENGLISH, "%.2f\n", kruskal());
		}
		
		in.close();
		System.exit(0);
	}
}
