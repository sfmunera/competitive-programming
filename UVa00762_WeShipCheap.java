package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 703 (762 - We Ship Cheap) */
/* SUBMISSION: 09054044 */
/* SUBMISSION TIME: 2011-07-16 15:35:06 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00762_WeShipCheap {
	
	static int N;
	static ArrayList<ArrayList<Integer>> G;
	static Map<String, Integer> vertices;
	
	static int[] bfs(int s) {
		int[] parent = new int[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(parent, -1);
		Queue<Integer> Q = new LinkedList<Integer>();
		
		visited[s] = true;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int w : G.get(v)) {
				if (!visited[w]) {
					visited[w] = true;
					parent[w] = v;
					Q.offer(w);
				}
			}
		}
		
		return parent;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean first = true;
		while (in.hasNext()) {
			int M = in.nextInt();
			N = 0;
			
			G = new ArrayList<ArrayList<Integer>>();
			vertices = new HashMap<String, Integer>();
			
			for (int i = 0; i < M; ++i) {
				String from = in.next();
				String to = in.next();
				if (!vertices.containsKey(from)) {
					vertices.put(from, N++);
					G.add(new ArrayList<Integer>());
				}
				
				if (!vertices.containsKey(to)) {
					vertices.put(to, N++);
					G.add(new ArrayList<Integer>());
				}
				G.get(vertices.get(from)).add(vertices.get(to));
				G.get(vertices.get(to)).add(vertices.get(from));
			}
			if (first)
				first = false;
			else
				System.out.println();
			String start = in.next();
			String dest = in.next();
			
			if (!vertices.containsKey(start) || !vertices.containsKey(dest)) {
				System.out.println("No route");
				continue;
			}
			int s = vertices.get(start);
			int d = vertices.get(dest);
			
			int[] parent = bfs(s);
			Stack<Integer> route = new Stack<Integer>();
			
			if (parent[d] == -1) {
				System.out.println("No route");
				continue;
			}
			int k = d;
			while (k != s) {
				route.add(k);
				k = parent[k];
			}
				
			int tmp = s;
			while (!route.isEmpty()) {
				int pop = route.pop();
				for (String v : vertices.keySet())
					if (vertices.get(v) == tmp) {
						System.out.print(v + " ");
						break;
					}
				for (String v : vertices.keySet())
					if (vertices.get(v) == pop) {
						System.out.println(v);
						break;
					}
				tmp = pop;
			}
		}
		
		in.close();
		System.exit(0);
	}
}