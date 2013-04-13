package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1551 (10610 - Gopher and Hawks) */
/* SUBMISSION: 10922116 */
/* SUBMISSION TIME: 2012-11-22 14:27:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10610_GopherandHawks {
	
	static int N;
	static ArrayList<ArrayList<Integer>> G;
	
	static int bfs() {
		int s = 0;
		int t = 1;
		int[] dist = new int[N];
		boolean[] visited = new boolean[N];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Arrays.fill(dist, -1);
		dist[s] = 0;
		visited[s] = true;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int u = Q.poll();
			if (u == t) return dist[u];
			for (int v : G.get(u))
				if (!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u] + 1;
					Q.offer(v);
				}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int v = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			
			if (v == 0 && m == 0) break;
			
			m *= 60;
			
			List<Double> x = new ArrayList<Double>();
			List<Double> y = new ArrayList<Double>();
			
			parts = in.readLine().split("[ ]+");
			x.add(Double.parseDouble(parts[0]));
			y.add(Double.parseDouble(parts[1]));
			
			parts = in.readLine().split("[ ]+");
			x.add(Double.parseDouble(parts[0]));
			y.add(Double.parseDouble(parts[1]));
			
			String line;
			while (true) {
				line = in.readLine().trim();
				if (line.isEmpty()) break;
				parts = line.split("[ ]+");
				x.add(Double.parseDouble(parts[0]));
				y.add(Double.parseDouble(parts[1]));
			}
			
			N = x.size();
			G = new ArrayList<ArrayList<Integer>>(N);
			
			for (int i = 0; i < N; ++i)
				G.add(new ArrayList<Integer>());
			
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j) {
					double dx = x.get(i) - x.get(j);
					double dy = y.get(i) - y.get(j);
					double d = Math.sqrt(dx * dx + dy * dy);
					double t = d / (double)v;
					
					if (Double.compare(t, m) <= 0) {
						G.get(i).add(j);
						G.get(j).add(i);
					}
				}
			
			int dist = bfs();
			if (dist == -1)
				System.out.println("No.");
			else {
				if (dist > 0) --dist;
				System.out.println("Yes, visiting " + dist + " other holes.");
			}
		}
		
		in.close();
		System.exit(0);
	}
}
