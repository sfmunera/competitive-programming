package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2001 (11060 - Beverages) */
/* SUBMISSION: 10773794 */
/* SUBMISSION TIME: 2012-10-22 02:26:04 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11060_Beverages {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int t = 1;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			
			String[] drinks = new String[N];
			Map<String, Integer> map = new HashMap<String, Integer>();
			boolean[][] adj = new boolean[N][N];
			int[] indegree = new int[N];
			
			for (int i = 0; i < N; ++i) {
				drinks[i] = in.readLine();
				map.put(drinks[i], i);
			}
			
			int M = Integer.parseInt(in.readLine());
			for (int i = 0; i < M; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int from = map.get(parts[0]);
				int to = map.get(parts[1]);
				
				if (!adj[from][to]) {
					adj[from][to] = true;
					++indegree[to];
				}
			}

			System.out.printf("Case #%d: Dilbert should drink beverages in this order:", t++);

			// BFS
			PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
			boolean[] visited = new boolean[N];
			
			for (int s = 0; s < N; ++s)
				if (indegree[s] == 0) {
					visited[s] = true;
					Q.offer(s);
				}
			while (!Q.isEmpty()) {
				int u = Q.poll();
				System.out.print(" " + drinks[u]);
				for (int v = 0; v < N; ++v) {
					if (adj[u][v]) {
						--indegree[v];
						if (!visited[v] && indegree[v] == 0) {
							visited[v] = true;
							Q.offer(v);
						}
					}
				}
			}

			System.out.print(".\n\n");
			
			in.readLine();
		}
		
		in.close();
		System.exit(0);
	}
}
