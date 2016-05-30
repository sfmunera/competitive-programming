package codeforces;

import java.util.*;

public class FormingTeams {
	
	static class MutableBoolean {
		boolean b;
		MutableBoolean() {
			this.b = false;
		}
	}
	
	static int dfs(int dad, int u, boolean[][] adj, Set<Integer> seen, MutableBoolean hasCycle) {
		seen.add(u);
		
		int size = 1;
		for (int v = 0; v < adj.length; ++v) {
			if (!adj[u][v]) continue;
			if (seen.contains(v) && v != dad) hasCycle.b = true;
			if (!seen.contains(v))
				size += dfs(u, v, adj, seen, hasCycle);
		}
		
		return size;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		boolean[][] adj = new boolean[n][n];
		
		for (int i = 0; i < m; ++i) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			
			adj[a][b] = adj[b][a] = true;
		}
		
		int ans = 0;
		int nonCycles = 0;
		Set<Integer> seen = new HashSet<Integer>();
		for (int i = 0; i < n; ++i) {
			if (!seen.contains(i)) {
				MutableBoolean hasCycle = new MutableBoolean();
				int size = dfs(-1, i, adj, seen, hasCycle);
				if (hasCycle.b) {
					ans += size % 2;
				} else {
					nonCycles += size;
				}
			}
		}
		
		ans += nonCycles % 2;
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
