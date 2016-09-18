package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3125 (11974 - Switch The Lights) */
/* SUBMISSION: 10924758 */
/* SUBMISSION TIME: 2012-11-23 04:35:10 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11974_SwitchTheLights {
	
	static int N, M;
	static int[] masks;
	
	static int bfs(int s) {
		int MAXN = (1 << N) + 5;
		int[] dist = new int[MAXN];
		boolean[] visited = new boolean[MAXN];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		dist[s] = 0;
		visited[s] = true;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int x = Q.poll();
			if (x == 0) return dist[x];
			for (int i = 0; i < M; ++i) {
				int next = x ^ masks[i];
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[x] + 1;
					Q.offer(next);
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			M = Integer.parseInt(parts[1]);
			
			masks = new int[M];
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				for (int j = 0; j < N; ++j)
					if (Integer.parseInt(parts[j]) == 1)
						masks[i] |= (1 << j);
			}
			
			int dist = bfs((1 << N) - 1);
			System.out.print("Case " + t + ": ");
			if (dist == -1)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(dist);
		}
		
		in.close();
		System.exit(0);
	}
}
