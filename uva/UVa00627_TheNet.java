package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 568 (627 - The Net) */
/* SUBMISSION: 09052090 */
/* SUBMISSION TIME: 2011-07-15 19:09:36 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00627_TheNet {
	
	static Set<Integer>[] G;
	static int N;
	
	static int[] bfs(int s) {
		int[] parent = new int[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(parent, -1);
		visited[s] = true;
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int w : G[v])
				if (!visited[w]) {
					visited[w] = true;
					parent[w] = v;
					Q.offer(w);
				}
		}
		return parent;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			N = Integer.parseInt(line);
			G = new TreeSet[N];
			
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[-]"); 
				int v = Integer.parseInt(parts[0]) - 1;
				G[v] = new TreeSet<Integer>();
				
				if (parts.length == 2) {
					line = parts[1];
					String[] neighs = line.split("[,]");
					for (int j = 0; j < neighs.length; ++j) {
						int w = Integer.parseInt(neighs[j]) - 1;
						G[i].add(w);
					}
				}
			}
			System.out.println("-----");
			int M = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < M; ++i) {
				line = in.readLine();
				String[] pair = line.split("[ ]");
				
				int start = Integer.parseInt(pair[0]) - 1;
				int dest = Integer.parseInt(pair[1]) - 1;
				
				int[] parent = bfs(start);
				Stack<Integer> route = new Stack<Integer>();
				
				if (parent[dest] != -1) {
					int k = dest;
					while (k != start) {
						route.push(k);
						k = parent[k];
					}
					String res = "" + (start + 1);
					while (!route.isEmpty())
						res += " " + (route.pop() + 1);
					System.out.println(res);
				} else {
					System.out.println("connection impossible");
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}
