package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 865 (924 - Spreading The News) */
/* SUBMISSION: 09054126 */
/* SUBMISSION TIME: 2011-07-16 16:05:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00924_SpreadingTheNews {
	
	static int E;
	static ArrayList<Integer>[] G;
	
	static int[] bfs(int s) {
		int[] distance = new int[E];
		boolean[] visited = new boolean[E];
		
		Arrays.fill(distance, -1);
		Queue<Integer> Q = new LinkedList<Integer>();
		
		visited[s] = true;
		distance[s] = 0;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int w : G[v])
				if (!visited[w]) {
					visited[w] = true;
					distance[w] = distance[v] + 1;
					Q.offer(w);
				}
		}
		
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			E = Integer.parseInt(line);
			G = new ArrayList[E];
			
			for (int i = 0; i < E; ++i) {
				line = in.readLine();
				String[] parts = line.split("[ ]");
				int N = Integer.parseInt(parts[0]);
				
				G[i] = new ArrayList<Integer>();
				for (int j = 1; j <= N; ++j)
					G[i].add(Integer.parseInt(parts[j]));
			}
			int T = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < T; ++i) {
				int s = Integer.parseInt(in.readLine());
				int[] distance = bfs(s);
				
				int maxDay = 0;
				for (int k = 0; k < E; ++k)
					maxDay = Math.max(maxDay, distance[k]);
				if (maxDay == 0)
					System.out.println(maxDay);
				else {
					int[] boom = new int[maxDay + 1];
					for (int k = 0; k < E; ++k)
						if (distance[k] >= 0)
							++boom[distance[k]];
					
					int maxboom = 0;
					int boomDay = 0;
					for (int d = 1; d <= maxDay; ++d)
						if (boom[d] > maxboom) {
							maxboom = boom[d];
							boomDay = d;
						}
					System.out.println(maxboom + " " + boomDay);
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}