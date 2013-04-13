package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1742 (10801 - Lift Hopping) */
/* SUBMISSION: 11563778 */
/* SUBMISSION TIME: 2013-04-05 22:50:36 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10801_LiftHopping {
	
	static int N;
	static boolean[][] elevators;
	static int[] T;
	
	static class QueueItem implements Comparable<QueueItem> {
		int dist, floor, elevator;
		public QueueItem(int dist, int floor, int elevator) {
			this.dist = dist; this.floor = floor; this.elevator = elevator;
		}
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}
	
	static int dijkstra(int s, int K) {
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		int[][] dist = new int[100][N];
		for (int i = 0; i < 100; ++i)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		dist[0][s] = 0;
		Q.offer(new QueueItem(0, 0, s));
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int d = q.dist;
			int f = q.floor;
			int e = q.elevator;
			
			if (d == dist[f][e]) {
				if (f == K) return d;
				
				for (int i = 0; i < 100; ++i) {
					if (i == f) continue;
					int w = T[e] * Math.abs(f - i);
					if (elevators[i][e] && dist[i][e] > dist[f][e] + w) {
						dist[i][e] = dist[f][e] + w;
						Q.offer(new QueueItem(dist[i][e], i, e));
					}
				}
				for (int j = 0; j < N; ++j) {
					if (j == e) continue;
					if (elevators[f][j] && dist[f][j] > dist[f][e] + 60) {
						dist[f][j] = dist[f][e] + 60;
						Q.offer(new QueueItem(dist[f][j], f, j));
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		String line;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			
			T = new int[N];
			elevators = new boolean[100][N]; // <floor, elevator>
			stk = new StringTokenizer(in.readLine());
			
			for (int i = 0; i < N; ++i)
				T[i] = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				while (stk.hasMoreTokens()) {
					int floor = Integer.parseInt(stk.nextToken());
					elevators[floor][i] = true;
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; ++i)
				if (elevators[0][i])
					ans = Math.min(ans, dijkstra(i, K));
			
			if (ans == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
			else System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
