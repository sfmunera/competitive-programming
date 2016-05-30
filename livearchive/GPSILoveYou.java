package livearchive;

import java.util.*;

public class GPSILoveYou {
	
	static final int INF = (int) 1e9;
	static int[][] d;
	static int[][] adj;
	static int[] path;
	
	static boolean isShortestPath(int i, int j) {
		int dist = 0;
		for (int k = i; k < j; ++k) {
			dist += adj[path[k]][path[k + 1]];
		}
		return dist == d[path[i]][path[j]];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			int N = in.nextInt();
			if (N == 0) break;
			
			adj = new int[N][N];
			d = new int[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					int w = in.nextInt();
					adj[i][j] = w == 0 ? INF : w;
				}
				adj[i][i] = 0;
			}
			
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					d[i][j] = adj[i][j];
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j)
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
			
			int m = in.nextInt();
			path = new int[m];
			for (int i = 0; i < m; ++i) {
				path[i] = in.nextInt();
			}
			
			int ans = 0;
			int i = 0;
			while (i < m - 1) {
				if (isShortestPath(i, m - 1)) break; // all good
				// take out longest prefix that is shortest path
				int j = m - 2;
				while (j >= i && !isShortestPath(i, j)) {
					--j;
				}
				++ans;
				i = j + 1;
			}
			
			System.out.println("Case " + t + ": " + ans);
			
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
