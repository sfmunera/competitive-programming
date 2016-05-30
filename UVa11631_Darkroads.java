package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2678 (11631 - Dark roads) */
/* SUBMISSION: 09073478 */
/* SUBMISSION TIME: 2011-07-23 17:18:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11631_Darkroads {
	
	static int M;
	static Vertex[] G;
	static final int INF = Integer.MAX_VALUE;
	
	static class Vertex {
		int id;
		List<Edge> adjacency = new ArrayList<Edge>();
		
		public Vertex(int id) {
			this.id = id;
		}
	}
	
	static class Edge {
		Vertex to;
		int weight;
		
		public Edge(Vertex to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {

		Vertex v;
		int distance;
		
		public QueueItem(Vertex v, int distance) {
			this.v = v;
			this.distance = distance;
		}
		
		public int compareTo(QueueItem q) {
			return this.distance - q.distance;
		}
		
	}
	
	static int prim(int s) {
		boolean[] intree = new boolean[M];
		int[] distance = new int[M];
		int[] parent = new int[M];
		int totalCost = 0;
		
		Arrays.fill(distance, INF);
		Arrays.fill(parent, -1);
		
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		distance[s] = 0;
		Q.offer(new QueueItem(G[s], 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			Vertex v = q.v;
			
			if (!intree[v.id]) {
				intree[v.id] = true;
				
				for (Edge edge : v.adjacency) {
					Vertex w = edge.to;
					int weight = edge.weight;
					
					if (!intree[w.id] && weight < distance[w.id]) {
						distance[w.id] = weight;
						parent[w.id] = v.id;
						Q.offer(new QueueItem(w, weight));
					}
				}
			}
		}
		
		for (int i = 0; i < M; ++i)
			totalCost += distance[i];
		
		return totalCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			M = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			int totalCost = 0;
			
			if (M == 0 && N == 0)
				break;
			
			G = new Vertex[M];
			for (int i = 0; i < M; ++i)
				G[i] = new Vertex(i);
			
			for (int i = 0; i < N; ++i) {
				line = in.readLine();
				stk = new StringTokenizer(line);
				int v = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				int cost = Integer.parseInt(stk.nextToken());
				totalCost += cost;
				
				G[v].adjacency.add(new Edge(G[w], cost));
				G[w].adjacency.add(new Edge(G[v], cost));
			}
			
			int minCost = prim(0);
			System.out.println(totalCost - minCost);
		}
		
		in.close();
		System.exit(0);
	}
}