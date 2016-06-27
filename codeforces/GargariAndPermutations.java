package codeforces;

import java.util.*;

public class GargariAndPermutations {
	
	static List<List<Integer>> graph;
	static int n;
	static final int INF = (int) 1e9;
	
	static boolean[] seen;
	static Stack<Integer> sort;

	static void dfs(int u) {
		seen[u] = true;

		for (int v : graph.get(u))
			if (!seen[v])
				dfs(v);
		sort.push(u);
	}

	static void topsort() {
		seen = new boolean[n];
		sort = new Stack<Integer>();

		for (int i = 0; i < n; ++i)
			if (!seen[i])
				dfs(i);
	}

	
	static int dagLongestPath() {
		int[] dist = new int[n];

		topsort();
		while (!sort.isEmpty()) {
			int u = sort.pop();
			for (int v : graph.get(u)) {
				if (dist[u] + 1 > dist[v]) {
					dist[v] = dist[u] + 1;
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; ++i)
			ans = Math.max(ans, dist[i] + 1);
		return ans;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		int k = in.nextInt();
		
		int[][] positions = new int[n][k];
		for (int i = 0; i < k; ++i) {
			for (int j = 0; j < n; ++j) {
				int x = in.nextInt() - 1;
				positions[x][i] = j;
			}
		}
		
		graph = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == j) continue;
				boolean valid = true;
				for (int l = 0; l < k; ++l) { 
					if (positions[i][l] > positions[j][l]) {
						valid = false;
						break;
					}
				}
				if (valid)
					graph.get(i).add(j);
			}
		}

		System.out.println(dagLongestPath());
		
		in.close();
		System.exit(0);
	}
}
