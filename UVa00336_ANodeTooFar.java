package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 272 (336 - A Node Too Far) */
/* SUBMISSION: 09048940 */
/* SUBMISSION TIME: 2011-07-14 17:55:05 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00336_ANodeTooFar {
	
	static Map<Integer, Integer> vertices;
	static boolean[][] G;
	static int N;
	
	static int[] bfs(int source) {
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		int[] parent = new int[N];
		
		Arrays.fill(distance, -1);
		Arrays.fill(parent, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.offer(source);
		int i = vertices.get(source);
		visited[i] = true;
		distance[i] = 0;
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			i = vertices.get(v);
			
			for (int w : vertices.keySet()) {
				int j = vertices.get(w);
				if (G[i][j] && !visited[j]) {
					visited[j] = true;
					distance[j] = distance[i] + 1;
					parent[j] = v;
					Q.offer(w);
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			int NC = in.nextInt();
			if (NC == 0)
				break;
			
			vertices = new HashMap<Integer, Integer>();
			G = new boolean[50][50];
			N = 0;
			
			for (int i = 0; i < NC; ++i) {
				int from = in.nextInt();
				int to = in.nextInt();
				
				if (!vertices.containsKey(from))
					vertices.put(from, N++);
				if (!vertices.containsKey(to))
					vertices.put(to, N++);
				
				G[vertices.get(to)][vertices.get(from)] = 
					G[vertices.get(from)][vertices.get(to)] = true;
			}
						
			while (true) {
				int source = in.nextInt();
				int ttl = in.nextInt();
				if (source == 0 && ttl == 0)
					break;
				
				int[] distance = bfs(source);
				int cnt = 0;
				for (int x : distance)
					if (x == -1 || x > ttl)
						++cnt;
				System.out.println("Case " + t + ": " + cnt + " nodes not reachable from node " + 
						source + " with TTL = " + ttl + ".");
				++t;
			}
		}
		
		in.close();
		System.exit(0);
	}
}