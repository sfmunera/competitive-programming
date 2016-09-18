package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1246 (10305 - Ordering Tasks) */
/* SUBMISSION: 09367559 */
/* SUBMISSION TIME: 2011-10-13 18:32:05 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10305_OrderingTasks {
	
	static int N;
	static boolean[][] adj;
	static boolean[] visited;
	static String sort;
	
	static void dfs(int s) {
		visited[s] = true;
		
		for (int i = 0; i < N; ++i)
			if (adj[s][i] && !visited[i])
				dfs(i);
		
		if (!sort.isEmpty())
			sort = " " + sort;
		sort = (s + 1) + sort;
	}
	
	static void topsort() {
		visited = new boolean[N];
		sort = "";
		
		for (int i = 0; i < N; ++i)
			if (!visited[i])
				dfs(i);
		System.out.println(sort);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && M == 0)
				break;
			
			adj = new boolean[N][N];
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(stk.nextToken()) - 1;
				int to = Integer.parseInt(stk.nextToken()) - 1;
				
				adj[from][to] = true;
			}
			
			topsort();
		}
		
		in.close();
		System.exit(0);
	}
}