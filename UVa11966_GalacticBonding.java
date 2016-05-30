package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3117 (11966 - Galactic Bonding) */
/* SUBMISSION: 11388485 */
/* SUBMISSION TIME: 2013-03-05 22:08:18 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11966_GalacticBonding {
	
	static int[] p;
	static int[] rank;
	static int N, sets;
	
	static void init() {
		p = new int[N];
		rank = new int[N];
		sets = N;
		for (int i = 0; i < N; ++i) {
			p[i] = i;
			rank[i] = 0;
		}
	}
	static int find(int u) {
		return (p[u] == u) ? u : (p[u] = find(p[u]));
	}

	static void merge(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (rank[pu] > rank[pv])
			p[pv] = pu;
		else
			p[pu] = pv;
		if (rank[pu] == rank[pv])
			++rank[pv];
		if (pu != pv)
			--sets;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer stk;
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			double D = Double.parseDouble(stk.nextToken());
			
			double[] X = new double[N];
			double[] Y = new double[N];
			
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				X[i] = Double.parseDouble(stk.nextToken());
				Y[i] = Double.parseDouble(stk.nextToken());
			}
			
			init();
			
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j)
					if (Math.sqrt((X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j])) <= D)
						merge(i, j);
			System.out.println("Case " + t + ": " + sets);
		}
		
		in.close();
		System.exit(0);
	}
}
