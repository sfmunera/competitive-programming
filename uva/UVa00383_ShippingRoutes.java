package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 319 (383 - Shipping Routes) */
/* SUBMISSION: 09049036 */
/* SUBMISSION TIME: 2011-07-14 18:34:33 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00383_ShippingRoutes {
	
	static boolean[][] adj;
	static Map<String, Integer> warehouses;
	static int M;
	
	static int[] bfs(int s) {
		int[] distance = new int[M];
		int[] parent = new int[M];
		boolean[] visited = new boolean[M];
		
		Arrays.fill(distance, -1);
		Arrays.fill(parent, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(s);
		visited[s] = true;
		distance[s] = 0;
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			visited[v] = true;
			
			for (int w = 0; w < M; ++w)
				if (adj[v][w] && !visited[w]) {
					visited[w] = true;
					distance[w] = distance[v] + 1;
					parent[w] = v;
					Q.offer(w);
				}
		}
		
		return distance;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		System.out.println("SHIPPING ROUTES OUTPUT");
		for (int t = 1; t <= T; ++t) {
			M = in.nextInt();
			int N = in.nextInt();
			int P = in.nextInt();
			
			System.out.println();
			System.out.println("DATA SET  " + t);
			System.out.println();
			
			adj = new boolean[M][M];
			warehouses = new HashMap<String, Integer>();
			
			for (int i = 0; i < M; ++i)
				warehouses.put(in.next(), i);
			for (int i = 0; i < N; ++i) {
				String from = in.next();
				String to = in.next();
				adj[warehouses.get(from)][warehouses.get(to)] = 
					adj[warehouses.get(to)][warehouses.get(from)] = true;
			}
			
			for (int i = 0; i < P; ++i) {
				int size = in.nextInt();
				String start = in.next();
				String dest = in.next();
				int[] distance = bfs(warehouses.get(start));
				int cost = distance[warehouses.get(dest)];
				
				if (cost == -1)
					System.out.println("NO SHIPMENT POSSIBLE");
				else
					System.out.println("$" + (100 * size * cost));
			}
		}
		System.out.println();
		System.out.println("END OF OUTPUT");
		in.close();
		System.exit(0);
	}
}