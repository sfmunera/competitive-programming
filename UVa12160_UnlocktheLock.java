package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3312 (12160 - Unlock the Lock) */
/* SUBMISSION: 10925087 */
/* SUBMISSION TIME: 2012-11-23 06:18:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12160_UnlocktheLock {
	
	static int L, U, R;
	static int[] buttonValues;
	
	static int bfs() {
		int s = L;
		int t = U;
		int MAXN = 10000;
		int[] dist = new int[MAXN];
		boolean[] visited = new boolean[MAXN];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		dist[s] = 0;
		visited[s] = true;
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int x = Q.poll();
			if (x == t) return dist[x];
			for (int i = 0; i < R; ++i) {
				int next = (x + buttonValues[i]) % MAXN;
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[x] + 1;
					Q.offer(next);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			L = Integer.parseInt(parts[0]);
			U = Integer.parseInt(parts[1]);
			R = Integer.parseInt(parts[2]);
			
			if (L == 0 && U == 0 && R == 0)  break;
			
			buttonValues = new int[R];
			parts = in.readLine().split("[ ]+");
			
			for (int i = 0; i < R; ++i)
				buttonValues[i] = Integer.parseInt(parts[i]);
			
			int dist = bfs();
			System.out.print("Case " + t + ": ");
			if (dist == -1)
				System.out.println("Permanently Locked");
			else
				System.out.println(dist);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
