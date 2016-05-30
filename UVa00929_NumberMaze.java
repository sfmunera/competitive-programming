package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 870 (929 - Number Maze) */
/* SUBMISSION: 09073990 */
/* SUBMISSION TIME: 2011-07-23 21:27:25 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00929_NumberMaze {
	
	static int N, M;
	static int[][] maze;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static final int INF = Integer.MAX_VALUE;
	
	static class QueueItem implements Comparable<QueueItem> {
		int r, c, distance;
		
		public QueueItem(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		public int compareTo(QueueItem q) {
			return this.distance - q.distance;
		}
	}
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	static int dijkstra(int sr, int sc, int tr, int tc) {
		boolean[][] visited = new boolean[N][M];
		int[][] distance = new int[N][M];
		PriorityQueue<QueueItem> Q = new PriorityQueue<QueueItem>();
		
		for (int i = 0; i < N; ++i)
			Arrays.fill(distance[i], INF);
		
		distance[sr][sc] = maze[sr][sc];
		Q.offer(new QueueItem(sr, sc, 0));
		
		while (!Q.isEmpty()) {
			QueueItem q = Q.poll();
			int r = q.r;
			int c = q.c;
			
			if (!visited[r][c]) {
				visited[r][c] = true;
				
				for (int d = 0; d < 4; ++d) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (!inside(nr, nc))
						continue;
					
					if (distance[nr][nc] > distance[r][c] + maze[nr][nc]) {
						distance[nr][nc] = distance[r][c] + maze[nr][nc];
						Q.offer(new QueueItem(nr, nc, distance[nr][nc]));
					}
				}
			}
		}

		return distance[tr][tc];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			maze = new int[N][M];
			
			for (int i = 0; i < N; ++i) {
				String line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				
				for (int j = 0; j < M; ++j)
					maze[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			int d = dijkstra(0, 0, N - 1, M - 1);
			System.out.println(d);
		}
		
		in.close();
		System.exit(0);
	}
}