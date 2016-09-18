package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1900 (10959 - The Party, Part I) */
/* SUBMISSION: 09056692 */
/* SUBMISSION TIME: 2011-07-17 17:01:31 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10959_ThePartyPartI {
	
	static List<Integer>[] G;
	static int P;
	
	static int[] bfs(int s) {
		int[] distance = new int[P];
		boolean[] visited = new boolean[P];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Arrays.fill(distance, -1);
		
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		boolean first = true;
		while (T-- > 0) {
			P = in.nextInt();
			int D = in.nextInt();
			
			G = new ArrayList[P];
			for (int i = 0; i < P; ++i)
				G[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < D; ++i) {
				int from = in.nextInt();
				int to = in.nextInt();
				
				G[from].add(to);
				G[to].add(from);
			}
			
			if (first)
				first = false;
			else
				System.out.println();
			
			int[] distance = bfs(0);
			for (int i = 1; i < P; ++i)
				System.out.println(distance[i]);
		}
	}
}