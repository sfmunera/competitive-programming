package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1626 (10685 - Nature) */
/* SUBMISSION: 10101162 */
/* SUBMISSION TIME: 2012-05-11 14:14:56 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10685_Nature {
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
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			if (N == 0 && M == 0)
				break;
			
			initSet(N);
			
			Map<String, Integer> index = new HashMap<String, Integer>();
			int k = 0;
			for (int i = 0; i < N; ++i)
				index.put(in.readLine(), k++);
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int x = index.get(parts[0]);
				int y = index.get(parts[1]);
				
				unionSet(x, y);
			}
			
			in.readLine();
			
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
