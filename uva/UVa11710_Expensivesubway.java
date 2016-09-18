package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2757 (11710 - Expensive subway) */
/* SUBMISSION: 09073565 */
/* SUBMISSION TIME: 2011-07-23 17:55:48 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11710_Expensivesubway {
	
	static int N;
	static final int INF = Integer.MAX_VALUE;
	static Map<String, ArrayList<Edge>> G;
	
	static class Edge {
		String to;
		int cost;
		
		public Edge(String to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class QueueItem implements Comparable<QueueItem> {
		String v;
		int distance;
		
		public QueueItem(String v, int distance) {
			this.v = v;
			this.distance = distance;
		}

		public int compareTo(QueueItem q) {
			return this.distance - q.distance;
		}
	}
	
	static int prim(String s) {
		Map<String, Boolean> intree = new HashMap<String, Boolean>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		int[] parent = new int[N];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		for (String v : G.keySet()) {
			intree.put(v, false);
			distance.put(v, INF);
		}
		
		distance.put(s, 0);
		Q.offer(new QueueItem(s, 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			String v = q.v;
			
			if (!intree.get(v)) {
				intree.put(v, true);
				
				for (Edge edge : G.get(v)) {
					String w = edge.to;
					int weight = edge.cost;
					
					if (!intree.get(w) && weight < distance.get(w)) {
						distance.put(w, weight);
						Q.offer(new QueueItem(w, weight));
					}
				}
			}
		}
		
		int totalCost = 0;
		for (String d : distance.keySet())
			if (distance.get(d) == INF)
				return -1;
			else
				totalCost += distance.get(d);
		return totalCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && M == 0)
				break;
			
			G = new HashMap<String, ArrayList<Edge>>();
			
			for (int i = 0; i < N; ++i) {
				String name = in.readLine();
				G.put(name, new ArrayList<Edge>());
			}
			
			for (int i = 0; i < M; ++i) {
				String[] parts = in.readLine().split("[ ]");
				String from = parts[0];
				String to = parts[1];
				int cost = Integer.parseInt(parts[2]);
				
				G.get(from).add(new Edge(to, cost));
				G.get(to).add(new Edge(from, cost));
			}
			String s = in.readLine();
			
			int totalCost = prim(s);
			
			System.out.println(totalCost == -1 ? "Impossible" : totalCost);
		}
		
		
		in.close();
		System.exit(0);
	}
}