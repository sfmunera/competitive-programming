package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 849 (908 - Re-connecting Computer Sites) */
/* SUBMISSION: 09073199 */
/* SUBMISSION TIME: 2011-07-23 15:13:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00908_ReconnectingComputerSites {
	
	static int N;
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
		boolean[] intree = new boolean[N];
		int[] distance = new int[N];
		int[] parent = new int[N];
		int cost = 0;
		
		Arrays.fill(distance, INF);
		Arrays.fill(parent, -1);
		
		distance[s] = 0;
		
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		Q.offer(new QueueItem(G[s], 0));
		
		while (!Q.isEmpty()) {
			QueueItem qi = Q.poll();
			Vertex v = qi.v;
			
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
		
		for (int i = 0; i < N; ++i)
			cost += distance[i];
		
		return cost;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		boolean first = true;
		while (in.hasNextInt()) {
			N = in.nextInt();
			Vertex[] T = new Vertex[N];
			G = new Vertex[N];
			
			for (int i = 0; i < N; ++i) {
				T[i] = new Vertex(i);
				G[i] = new Vertex(i);
			}
			
			int originalCost = 0;
			
			for (int i = 0; i < N - 1; ++i) {
				int v = in.nextInt();
				int w = in.nextInt();
				int cost = in.nextInt();
				T[v - 1].adjacency.add(new Edge(T[w - 1], cost));
				T[w - 1].adjacency.add(new Edge(T[v - 1], cost));
				
				originalCost += cost;
			}
			
			int K = in.nextInt();
			for (int i = 0; i < K; ++i) {
				int v = in.nextInt();
				int w = in.nextInt();
				int cost = in.nextInt();
				G[v - 1].adjacency.add(new Edge(G[w - 1], cost));
				G[w - 1].adjacency.add(new Edge(G[v - 1], cost));
			}
			int M = in.nextInt();
			for (int i = 0; i < M; ++i) {
				int v = in.nextInt();
				int w = in.nextInt();
				int cost = in.nextInt();
				G[v - 1].adjacency.add(new Edge(G[w - 1], cost));
				G[w - 1].adjacency.add(new Edge(G[v - 1], cost));
			}
			
			int newCost = prim(0);
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(originalCost);
			System.out.println(newCost);
		}
		
		in.close();
		System.exit(0);
	}
}