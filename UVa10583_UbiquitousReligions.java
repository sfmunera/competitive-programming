package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1524 (10583 - Ubiquitous Religions) */
/* SUBMISSION: 10101048 */
/* SUBMISSION TIME: 2012-05-11 13:57:20 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10583_UbiquitousReligions {
	
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
		
		int t = 1;
		while (true) {
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
			
			Set<Integer> sets = new HashSet<Integer>();
			for (int i = 0; i < N; ++i)
				sets.add(findSet(i));
			System.out.println("Case " + t + ": " + sets.size());
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
