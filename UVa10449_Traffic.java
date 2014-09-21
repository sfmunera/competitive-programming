package uva;

import java.util.*;
import java.io.*;

public class UVa10449_Traffic {
	
	static final long INF = Long.MAX_VALUE / 3;
	static int n;
	static boolean[][] adj;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (in.hasNext()) {
			try {
				n = in.nextInt();
			} catch (Exception e) {
				break;
			}
			
			long[] busyness = new long [n];
			adj = new boolean[n][n];
			
			for (int i = 0; i < n; ++i)
				busyness[i] = in.nextLong();
			int r = in.nextInt();
			for (int i = 0; i < r; ++i) {
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				adj[a][b] = true;
			}
			
			long[] dist = new long[n];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			for (int i = 0; i < n - 1; ++i)
				for (int u = 0; u < n; ++u)
					for (int v = 0; v < n; ++v)
						if (adj[u][v]) {
							long d = busyness[v] - busyness[u];
							long w = d * d * d;
							if (dist[u] < INF && dist[u] + w < dist[v])
								dist[v] = dist[u] + w;
						}
			
			for (int u = 0; u < n; ++u)
				for (int v = 0; v < n; ++v)
					if (adj[u][v]) {
						long d = busyness[v] - busyness[u];
						long w = d * d * d;
						if (dist[u] < INF && dist[u] + w < dist[v])
							dist[v]  = -INF;
					}
			
			System.out.println("Set #" + t);
			int q = in.nextInt();
			for (int i = 0; i < q; ++i) {
				int x = in.nextInt() - 1;
				if (x < 0 || x >= n || dist[x] >= INF || dist[x] < 3)
					System.out.println("?");
				else 
					System.out.println(dist[x]);
			}
			++t;
		}
		in.close();
		System.exit(0);
	}
	
}
