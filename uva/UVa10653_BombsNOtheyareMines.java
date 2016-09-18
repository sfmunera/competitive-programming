package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1594 (10653 - Bombs! NO they are Mines!!) */
/* SUBMISSION: 09055192 */
/* SUBMISSION TIME: 2011-07-17 00:47:26 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10653_BombsNOtheyareMines {
	
	static int R, C;
	static char[][] grid;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static int bfs(int sr, int sc, int tr, int tc) {
		int[][] distance = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		
		for (int i = 0; i < R; ++i)
			Arrays.fill(distance[i], -1);
		
		distance[sr][sc] = 0;
		visited[sr][sc] = true;
		Qr.offer(sr);
		Qc.offer(sc);
		
		while (!Qr.isEmpty()) {
			int vr = Qr.poll();
			int vc = Qc.poll();
			
			for (int d = 0; d < 4; ++d) {
				int nr = vr + dr[d];
				int nc = vc + dc[d];
				if (inside(nr, nc) && !visited[nr][nc] && grid[nr][nc] == '.') {
					visited[nr][nc] = true;
					distance[nr][nc] = distance[vr][vc] + 1;
					
					if (nr == tr && nc == tc)
						return distance[nr][nc];
					Qr.offer(nr);
					Qc.offer(nc);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			R = in.nextInt();
			C = in.nextInt();
			
			if (R == 0 && C == 0)
				break;
			grid = new char[R][C];
			for (int i = 0; i < R; ++i)
				Arrays.fill(grid[i], '.');
			
			int M = in.nextInt();
			for (int i = 0; i < M; ++i) {
				int r = in.nextInt();
				int n = in.nextInt();
				for (int j = 0; j < n; ++j)
					grid[r][in.nextInt()] = '#';
			}
			int sr = in.nextInt();
			int sc = in.nextInt();
			int tr = in.nextInt();
			int tc = in.nextInt();
			
			int d = bfs(sr, sc, tr, tc);
			System.out.println(d);
		}
		
		in.close();
		System.exit(0);
	}
}