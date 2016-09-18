package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 183 (247 - Calling Circles) */
/* SUBMISSION: 09368237 */
/* SUBMISSION TIME: 2011-10-13 23:00:04 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00247_CallingCircles {
	
	static int N;
	static boolean[][] adj;
	static boolean[] visited;
	static List<Integer> sort;
	static Map<Integer, String> map;
	
	static void dfs(int s) {
		visited[s] = true;
		
		for (int i = 0; i < N; ++i)
			if (adj[s][i] && !visited[i])
				dfs(i);
		
		sort.add(0, s);
	}
	
	static void topsort() {
		visited = new boolean[N];
		sort = new ArrayList<Integer>();
		
		for (int i = 0; i < N; ++i)
			if (!visited[i])
				dfs(i);
	}
	
	static void dfs2(int s, boolean first) {
		visited[s] = true;
		
		if (!first)
			System.out.print(", ");
		System.out.print(map.get(s));
		
		for (int i = 0; i < N; ++i)
			if (adj[i][s] && !visited[i])
				dfs2(i, false);
	}
	
	static void scc() {
		topsort();
		
		visited = new boolean[N];
		for (int x : sort)
			if (!visited[x]) {
				dfs2(x, true);
				System.out.println();
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;
		int t = 1;
		boolean first = true;
		while (true) {
			stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && M == 0)
				break;
			
			adj = new boolean[N][N];
			map = new HashMap<Integer, String>();
			
			int k = 0;
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				String from = stk.nextToken();
				String to = stk.nextToken();
				
				if (!map.containsValue(from))
					map.put(k++, from);
				if (!map.containsValue(to))
					map.put(k++, to);
				
				int v = 0;
				int w = 0;
				for (int x : map.keySet()) {
					if (map.get(x).equals(from)) {
						v = x;
						//System.out.println(v + ": " + from);
					}
					if (map.get(x).equals(to)) {
						w = x;
						//System.out.println(w + ": " + to);
					}
				}
				
				adj[v][w] = true;
			}
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println("Calling circles for data set " + t + ":");
			scc();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}