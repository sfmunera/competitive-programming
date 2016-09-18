package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1549 (10608 - Friends) */
/* SUBMISSION: 10101085 */
/* SUBMISSION TIME: 2012-05-11 14:03:23 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10608_Friends {
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			if (N == 0 && M == 0)
				break;
			
			initSet(N);
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int x = Integer.parseInt(parts[0]) - 1;
				int y = Integer.parseInt(parts[1]) - 1;
				
				unionSet(x, y);
			}
			
			int[] cnt = new int[N];
			for (int i = 0; i < N; ++i)
				++cnt[findSet(i)];
			
			int max = 0;
			for (int i = 0; i < N; ++i)
				max = Math.max(max, cnt[i]);
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}
