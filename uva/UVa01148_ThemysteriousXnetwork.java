package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3589 (1148 - The mysterious X network) */
/* SUBMISSION: 09282784 */
/* SUBMISSION TIME: 2011-09-21 00:41:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01148_ThemysteriousXnetwork {
	
	static class Vertex {
		int id;
		List<Edge> adj = new ArrayList<Edge>();
		
		public Vertex(int id) {
			this.id = id;
		}
	}
	
	static class Edge {
		int to;
		
		public Edge(int to) {
			this.to = to;
		}
	}
	
	static Vertex[] G;
	static int N;
	
	static int bfs(int s, int t) {
		boolean[] visited = new boolean[N];
		int[] distance = new int[N];
		Queue<Vertex> Q = new LinkedList<Vertex>();
		
		Arrays.fill(distance, -1);
		
		visited[s] = true;
		distance[s] = 0;
		Q.offer(G[s]);
		
		while (!Q.isEmpty()) {
			Vertex v = Q.poll();
			if (v.id == t)
				return distance[v.id];
			
			for (Edge edge : v.adj) {
				int w = edge.to;
				if (!visited[w]) {
					visited[w] = true;
					distance[w] = distance[v.id] + 1;
					Q.offer(G[w]);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(new File("a.in"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			G = new Vertex[N];
			
			for (int i = 0; i < N; ++i)
				G[i] = new Vertex(i);
			for (int i = 0; i < N; ++i) {
				String line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				int from = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				for (int j = 0; j < m; ++j) {
					int to = Integer.parseInt(stk.nextToken());
					G[from].adj.add(new Edge(to));
					G[to].adj.add(new Edge(from));
				}
			}

			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int s = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			
			int d = bfs(s, t);
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(s + " " + t + " " + (d - 1));
		}
		
		in.close();
		System.exit(0);
	}
}