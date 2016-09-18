package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2737 (11690 - Money Matters) */
/* SUBMISSION: 11412182 */
/* SUBMISSION TIME: 2013-03-09 23:12:50 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11690_MoneyMatters {
	
	static int[] p, rank, owes;
	static int N;
	
	static void init() {
		p = new int[N];
		rank = new int[N];
		
		for (int i = 0; i < N; ++i) {
			p[i] = i;
			rank[i] = 0;
		}
	}
	
	static int find(int u) {
		return p[u] == u ? u : (p[u] = find(p[u]));
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
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			owes = new int[N];
			for (int i = 0; i < N; ++i)
				owes[i] = Integer.parseInt(in.readLine());
			
			init();
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				
				merge(u, v);
			}
			int[] sum = new int[N];
			for (int i = 0; i < N; ++i) {
				int pi = find(i);
				sum[pi] += owes[i];
			}
			
			boolean possible = true;
			for (int i = 0; i < N && possible; ++i)
				possible &= sum[i] == 0;
			System.out.println((possible ? "" : "IM") + "POSSIBLE");
		}
		
		in.close();
		System.exit(0);
	}
}
