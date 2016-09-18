package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 556 (615 - Is It A Tree?) */
/* SUBMISSION: 11537262 */
/* SUBMISSION TIME: 2013-03-31 14:01:04 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00615_IsItATree {
	
	static ArrayList<ArrayList<Integer>> G;
	static boolean[] seen;
	static boolean[] intree;
	static int[] indegree;
	
	static boolean dfs(int u) {
		seen[u] = true;
		for (int v : G.get(u))
			if (seen[v] || !dfs(v)) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int k = 1;
		while (in.hasNext()) {
			int u = in.nextInt();
			int v = in.nextInt();
			
			if (u < 0 && v < 0) break;
			
			int N = Math.max(u, v);
			ArrayList<Integer> from = new ArrayList<Integer>();
			ArrayList<Integer> to = new ArrayList<Integer>();
			
			if (u == 0 && v == 0) {
				System.out.println("Case " + k + " is a tree.");
				++k;
				continue;
			}
			
			from.add(u);
			to.add(v);
			
			while (in.hasNext()) {
				u = in.nextInt();
				v = in.nextInt();
				
				if (u == 0 && v == 0) break;
				
				from.add(u);
				to.add(v);
				
				N = Math.max(N, Math.max(u, v));
			}
			
			intree = new boolean[N];
			indegree = new int[N];
			
			G = new ArrayList<ArrayList<Integer>>(N);
			for (int i = 0; i < N; ++i)
				G.add(new ArrayList<Integer>());
			
			for (int i = 0; i < from.size(); ++i) {
				int f = from.get(i) - 1;
				int t = to.get(i) - 1;
				G.get(f).add(t);
				intree[f] = true;
				intree[t] = true;
				++indegree[t];
			}
			
			boolean isTree = true;
			
			int roots = 0;
			int s = 0;
			for (int i = 0; i < N; ++i)
				if (intree[i] && indegree[i] == 0) {
					++roots;
					s = i;
				}
			if (roots != 1) isTree = false;
			else {
				seen = new boolean[N];
				if (!dfs(s))
					isTree = false;
				else {
					for (int i = 0; i < N; ++i)
						if (intree[i] && !seen[i])
							isTree = false;
				}
			}
			System.out.println("Case " + k + " is" + (isTree ? "" : " not") + " a tree.");
			++k;
		}
		
		in.close();
		System.exit(0);
	}
}
