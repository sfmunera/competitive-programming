package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2021 (11080 - Place the Guards) */
/* SUBMISSION: 10598560 */
/* SUBMISSION TIME: 2012-09-13 18:25:30 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11080_PlacetheGuards {
	
	static int N;
	static ArrayList<Integer>[] G;
	static int[] color;
	static boolean[] visited;
	static boolean failed;
	static int total;
	
	static int dfs(int u, int c) {
		visited[u] = true;
		color[u] = c;
		++total;
		
		int cnt = 0;
		for (int v : G[u])
			if (!visited[v])
				cnt += dfs(v, 1 - c);
			else if (color[u] == color[v])
				failed = true;
		
		return c + cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			G = new ArrayList[N];
			for (int i = 0; i < N; ++i)
				G[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]);
				int v = Integer.parseInt(parts[1]);
				
				G[u].add(v);
				G[v].add(u);
			}
			int ans = 0;
			visited = new boolean[N];
			color = new int[N];
			Arrays.fill(color, -1);
			for (int k = 0; k < N; ++k) {
				if (!visited[k]) {
					total = 0;
					failed = false;
					int black = dfs(k, 0);
					
					if (total == 1)
						++ans;
					else
						ans += Math.min(black, total - black);
				}
			}
			
			if (failed)
				ans = -1;
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
