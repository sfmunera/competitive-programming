package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 869 (928 - Eternal Truths) */
/* SUBMISSION: 11081163 */
/* SUBMISSION TIME: 2012-12-28 04:57:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00928_EternalTruths {
	
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean valid(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] != '#';
	}
	
	static int bfs(int sr, int sc, int tr, int tc) {
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		Queue<Integer> Qj = new LinkedList<Integer>();
		int[][][] dist = new int[R][C][3];
		boolean[][][] visited = new boolean[R][C][3];
		
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				Arrays.fill(dist[i][j], -1);
		
		Qr.offer(sr);
		Qc.offer(sc);
		Qj.offer(0);
		dist[sr][sc][0] = 0;
		visited[sr][sc][0] = true;
		
		while (!Qr.isEmpty()) {
			int r = Qr.poll();
			int c = Qc.poll();
			int jump = Qj.poll();
			if (r == tr && c == tc)
				return dist[r][c][jump];
			for (int i = 0; i < 4; ++i) {
				boolean ok = true;
				for (int k = 1; k <= jump + 1; ++k) {
					int nr = r + k * dr[i];
					int nc = c + k * dc[i];
					if (!valid(nr, nc))
						ok = false;
				}
				int nr = r + (jump + 1) * dr[i];
				int nc = c + (jump + 1) * dc[i];
				int njump = (jump + 1) % 3;
				if (ok && !visited[nr][nc][njump]) {
					visited[nr][nc][njump] = true;
					dist[nr][nc][njump] = dist[r][c][jump] + 1;
					Qr.offer(nr);
					Qc.offer(nc);
					Qj.offer(njump);
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			
			map = new char[R][C];
			for (int i = 0; i < R; ++i)
				map[i] = in.readLine().toCharArray();
			
			int sr = 0;
			int sc = 0;
			int tr = 0;
			int tc = 0;
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					if (map[i][j] == 'S') {
						sr = i;
						sc = j;
					} else if (map[i][j] == 'E') {
						tr = i;
						tc = j;
					}
			int dist = bfs(sr, sc, tr, tc);
			System.out.println(dist == -1 ? "NO" : dist);
		}
		
		in.close();
		System.exit(0);
	}
}
