package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3638 (1197 - The Suspects) */
/* SUBMISSION: 10929953 */
/* SUBMISSION TIME: 2012-11-24 05:07:20 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa01197_TheSuspects {
	
	static int[] pset, rank;
	
	static void init(int N) {
		pset = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; ++i) {
			pset[i] = i;
			rank[i] = 0;
		}
	}
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			if (N == 0 && M == 0) break;
			
			init(N);
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int k = Integer.parseInt(parts[0]);
				for (int j = 2; j <= k; ++j) {
					int u = Integer.parseInt(parts[j - 1]);
					int v = Integer.parseInt(parts[j]);
					merge(u, v);
				}
			}
			int p = find(0);
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				if (find(i) == p)
					++cnt;
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
