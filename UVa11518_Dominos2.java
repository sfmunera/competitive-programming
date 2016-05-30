package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2513 (11518 - Dominos 2) */
/* SUBMISSION: 09043659 */
/* SUBMISSION TIME: 2011-07-13 01:47:15 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11518_Dominos2 {
	
	static int n;
	static List<Integer>[] G;
	static boolean[] visited;
	
	static int dfs(int v) {
		if (visited[v])
			return 0;
		
		visited[v] = true;
		
		int cnt = 1;
		for (int w : G[v])
			cnt += dfs(w);
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			n = in.nextInt();
			int m = in.nextInt();
			int l = in.nextInt();
			
			G = new ArrayList[n];
			visited = new boolean[n];
			for (int i = 0; i < n; ++i)
				G[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < m; ++i) {
				int x = in.nextInt();
				int y = in.nextInt();
				G[x - 1].add(y - 1);
			}
			
			int cnt = 0;
			for (int i = 0; i < l; ++i) {
				int v = in.nextInt();
				if (!visited[v - 1])
					cnt += dfs(v - 1);
			}
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}