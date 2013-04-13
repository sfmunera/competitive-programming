package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2620 (11573 - Ocean Currents) */
/* SUBMISSION: 11434877 */
/* SUBMISSION TIME: 2013-03-14 01:01:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11573_OceanCurrents {
	
	static final int INF = (int)1e9;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int R, C;
	static char[][] field;
	
	static class QueueItem implements Comparable<QueueItem> {
		int r, c, dist;
		public QueueItem(int r, int c, int dist) {
			this.r = r; this.c = c; this.dist = dist;
		}
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static int dijkstra(int rs, int cs, int rd, int cd) {
		int[][] dist = new int[R][C];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		for (int i = 0; i < R; ++i)
			Arrays.fill(dist[i], INF);
		
		dist[rs][cs] = 0;
		Q.offer(new QueueItem(rs, cs, 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int r = q.r;
			int c = q.c;
			int d = q.dist;
			
			if (dist[r][c] == d) {
				if (r == rd && c == cd) return dist[r][c];
				
				for (int k = 0; k < 8; ++k) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					int w = k == field[r][c] - '0' ? 0 : 1;
					if (inside(nr, nc) && dist[r][c] + w < dist[nr][nc]) {
						dist[nr][nc] = dist[r][c] + w;
						Q.offer(new QueueItem(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		
		field = new char[R][C];
		for (int i = 0; i < R; ++i)
			field[i] = in.readLine().toCharArray();
		
		int N = Integer.parseInt(in.readLine());
		while (N-- > 0) {
			stk = new StringTokenizer(in.readLine());
			int rs = Integer.parseInt(stk.nextToken()) - 1;
			int cs = Integer.parseInt(stk.nextToken()) - 1;
			int rd = Integer.parseInt(stk.nextToken()) - 1;
			int cd = Integer.parseInt(stk.nextToken()) - 1;
			
			System.out.println(dijkstra(rs, cs, rd, cd));
		}
		
		in.close();
		System.exit(0);
	}
}
