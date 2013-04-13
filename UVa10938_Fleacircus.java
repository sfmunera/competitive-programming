package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1879 (10938 - Flea circus) */
/* SUBMISSION: 11537705 */
/* SUBMISSION TIME: 2013-03-31 15:46:39 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10938_Fleacircus {
	
	static int N;
	static ArrayList<ArrayList<Integer>> G;
	
	static ArrayList<Integer> bfs(int s, int t) {
		Queue<Integer> Q = new LinkedList<Integer>();
		int[] p = new int[N];
		boolean[] seen = new boolean[N];
		Arrays.fill(p, -1);
		
		seen[s] = true;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int u = Q.poll();
			if (u == t) break;
			
			for (int v : G.get(u))
				if (!seen[v]) {
					seen[v] = true;
					p[v] = u;
					Q.offer(v);
				}
		}
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		int cur = t;
		while (cur != -1) {
			path.add(cur);
			cur = p[cur];
		}
		
		return path;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			G = new ArrayList<ArrayList<Integer>>(N);
			for (int i = 0; i < N; ++i)
				G.add(new ArrayList<Integer>());
			
			for (int i = 0; i < N - 1; ++i) {
				stk = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(stk.nextToken()) - 1;
				int v = Integer.parseInt(stk.nextToken()) - 1;
				
				G.get(u).add(v);
				G.get(v).add(u);
			}
			
			int L = Integer.parseInt(in.readLine());
			for (int i = 0; i < L; ++i) {
				stk = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(stk.nextToken()) - 1;
				int t = Integer.parseInt(stk.nextToken()) - 1;

				ArrayList<Integer> path = bfs(s, t);
				
				if (path.size() % 2 == 1)
					System.out.println("The fleas meet at " + (path.get(path.size() / 2) + 1) + ".");
				else if (path.size() > 0) {
					int p = path.get((path.size() - 1) / 2);
					int q = path.get((path.size() - 1) / 2 + 1);
					System.out.println("The fleas jump forever between " + (Math.min(p, q) + 1) + " and " + (Math.max(p, q) + 1) + ".");
				} else
					System.out.println("The fleas meet at " + (s + 1) + ".");
			}
		}
		
		in.close();
		System.exit(0);
	}
}
