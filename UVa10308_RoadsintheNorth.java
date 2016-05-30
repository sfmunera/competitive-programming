package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1249 (10308 - Roads in the North) */
/* SUBMISSION: 11537492 */
/* SUBMISSION TIME: 2013-03-31 14:51:46 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10308_RoadsintheNorth {
	
	static class Edge {
		int to, w;
		public Edge(int to, int w) {
			this.to = to; this.w = w;
		}
	}
	
	static ArrayList<ArrayList<Edge>> G;
	static int[] degree;
	static boolean[] seen;
	
	static int dfs(int u) {
		int ans = 0;
		for (Edge e : G.get(u)) {
			int v = e.to;
			int w = e.w;
			if (!seen[v]) {
				seen[v] = true;
				ans = Math.max(ans, w + dfs(v));
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			if (line.isEmpty()) {
				System.out.println(0);
				while ((line = in.readLine()) != null && line.isEmpty());
			}
			int N = 0;
			ArrayList<Integer> from = new ArrayList<Integer>();
			ArrayList<Integer> to = new ArrayList<Integer>();
			ArrayList<Integer> length = new ArrayList<Integer>();
			
			StringTokenizer stk = new StringTokenizer(line);
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			N = Math.max(u, v);
			from.add(u);
			to.add(v);
			length.add(w);
			
			while ((line = in.readLine()) != null && !line.isEmpty()) {
				stk = new StringTokenizer(line);
				u = Integer.parseInt(stk.nextToken());
				v = Integer.parseInt(stk.nextToken());
				w = Integer.parseInt(stk.nextToken());
				
				N = Math.max(N, Math.max(u, v));
				from.add(u);
				to.add(v);
				length.add(w);
			}
			degree = new int[N];
			
			G = new ArrayList<ArrayList<Edge>>(N);
			for (int i = 0; i < N; ++i)
				G.add(new ArrayList<Edge>());
			
			for (int i = 0; i < from.size(); ++i) {
				int f = from.get(i) - 1;
				int t = to.get(i) - 1;
				int l = length.get(i);
				G.get(f).add(new Edge(t, l));
				G.get(t).add(new Edge(f, l));
				++degree[f];
				++degree[t];
			}
			
			int ans = 0;
			for (int i = 0; i < N; ++i)
				if (degree[i] == 1) {
					seen = new boolean[N];
					seen[i] = true;
					ans = Math.max(ans, dfs(i));
				}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
