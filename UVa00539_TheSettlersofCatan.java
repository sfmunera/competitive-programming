package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 480 (539 - The Settlers of Catan) */
/* SUBMISSION: 09381592 */
/* SUBMISSION TIME: 2011-10-17 17:11:52 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00539_TheSettlersofCatan {
	
	static int N;
	static boolean[][] adj;
	static boolean[][] visited;
	static int max;
	
	static void dfs(int s, int k) {

		max = Math.max(max, k);
		for (int i = 0; i < N; ++i)
			if (adj[s][i] && !visited[s][i]) {
				visited[s][i] = visited[i][s] = true;
				dfs(i, k + 1);
				visited[s][i] = visited[i][s] = false;
			}				
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
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				
				adj[from][to] = adj[to][from] = true;
			}
			
			max = 0;
			for (int i = 0; i < N; ++i) {
				visited = new boolean[N][N];
				dfs(i, 0);
			}
			
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}
