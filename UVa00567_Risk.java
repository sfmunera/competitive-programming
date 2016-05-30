package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 508 (567 - Risk) */
/* SUBMISSION: 09051902 */
/* SUBMISSION TIME: 2011-07-15 18:01:41 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00567_Risk {
	
	static boolean[][] adj;
	
	static int[] bfs(int s) {
		int[] distance = new int[20];
		boolean[] visited = new boolean[20];
		
		Arrays.fill(distance, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		visited[s] = true;
		distance[s] = 0;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int w = 0; w < 20; ++w)
				if (adj[v][w] && !visited[w]) {
					visited[w] = true;
					distance[w] = distance[v] + 1;
					Q.offer(w);
				}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (in.hasNextLine()) {
			adj = new boolean[20][20];

			for (int i = 1; i < 20; ++i) {
				String line = in.nextLine();
				StringTokenizer stk = new StringTokenizer(line);
				int n = Integer.parseInt(stk.nextToken());
				
				for (int j = 0; j < n; ++j) {
					int v = Integer.parseInt(stk.nextToken());
					adj[i - 1][v - 1] = adj[v - 1][i - 1] = true;
				}
			}
			System.out.println("Test Set #" + t);
			int N = Integer.parseInt(in.nextLine());
			for (int i = 0; i < N; ++i) {
				String line = in.nextLine();
				StringTokenizer stk = new StringTokenizer(line);
				int start = Integer.parseInt(stk.nextToken());
				int dest = Integer.parseInt(stk.nextToken());
				
				int[] distance = bfs(start - 1);
				System.out.println((start < 10 ? " " : "") + start + 
						" to " + (dest < 10 ? " " : "") + dest + ": " + distance[dest - 1]);
			}
			System.out.println();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}