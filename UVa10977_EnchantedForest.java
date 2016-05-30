package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1918 (10977 - Enchanted Forest) */
/* SUBMISSION: 10922311 */
/* SUBMISSION TIME: 2012-11-22 15:03:45 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10977_EnchantedForest {
	
	static int R, C;
	static boolean[][] blocked;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static int bfs() {
		int sr = 0;
		int sc = 0;
		int tr = R - 1;
		int tc = C - 1;
		
		if (blocked[sr][sc]) return -1;
		
		int[][] dist = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		
		for (int i = 0; i < R; ++i)
			Arrays.fill(dist[i], -1);
		
		dist[sr][sc] = 0;
		visited[sr][sc] = true;
		Qr.offer(sr);
		Qc.offer(sc);
		
		while (!Qr.isEmpty()) {
			int r = Qr.poll();
			int c = Qc.poll();
			
			if (r == tr && c == tc) return dist[r][c];
			for (int i = 0; i < 4; ++i) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (inside(nr, nc) && !blocked[nr][nc] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dist[nr][nc] = dist[r][c] + 1;
					Qr.offer(nr);
					Qc.offer(nc);
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			R = Integer.parseInt(parts[0]);
			C = Integer.parseInt(parts[1]);
			
			if (R == 0 && C == 0) break;
			
			blocked = new boolean[R][C];
			
			int m = Integer.parseInt(in.readLine());
			for (int i = 0; i < m; ++i) {
				parts = in.readLine().split("[ ]+");
				int r = Integer.parseInt(parts[0]) - 1;
				int c = Integer.parseInt(parts[1]) - 1;
				
				blocked[r][c] = true;
			}
			int n = Integer.parseInt(in.readLine());
			for (int i = 0; i < n; ++i) {
				parts = in.readLine().split("[ ]+");
				int r = Integer.parseInt(parts[0]) - 1;
				int c = Integer.parseInt(parts[1]) - 1;
				int l = Integer.parseInt(parts[2]);
				
				for (int j = r - l; j <= r + l; ++j)
					for (int k = c - l; k <= c + l; ++k) {
						int dr = r - j;
						int dc = c - k;
						if (dr * dr + dc * dc <= l * l && inside(j, k))
							blocked[j][k] = true;
					}
			}
			
			int dist = bfs();
			System.out.println(dist == -1 ? "Impossible." : dist);
		}
		
		in.close();
		System.exit(0);
	}
}
