package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 762 (821 - Page Hopping) */
/* SUBMISSION: 09377987 */
/* SUBMISSION TIME: 2011-10-16 16:57:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00821_PageHopping {
	
	static final int INF = Integer.MAX_VALUE / 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			int[][] adj = new int[101][101];
			for (int i = 0; i < 101; ++i) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}
			
			int N = 0;
			while (true) {
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				
				if (from == 0 && to == 0)
					break;
								
				N = Math.max(N, Math.max(from, to));
				
				adj[from - 1][to - 1] = 1;
			}
			
			if (N == 0)
				break;
			
			//for (int i = 0; i < N; ++i)
			//	System.out.println(Arrays.toString(adj[i]));
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
			
			//for (int i = 0; i < N; ++i)
			//	System.out.println(Arrays.toString(adj[i]));
			
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (i != j && adj[i][j] != INF) {
						sum += adj[i][j];
						++cnt;
					}
			
			System.out.printf(Locale.ENGLISH, "Case %d: average length between pages = %.3f clicks%n", t, (double)sum / cnt);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}