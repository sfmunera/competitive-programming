package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 988 (10047 - The Monocycle) */
/* SUBMISSION: 11467396 */
/* SUBMISSION TIME: 2013-03-19 02:18:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10047_TheMonocycle {
	
	static int M, N;
	static char[][] grid;
	
	static int[] dr = {-1, 0, 1, 0}; // NESW
	static int[] dc = {0, 1, 0, -1};
	
	static class Item {
		int r, c, dir, color;
		public Item(int r, int c, int dir, int color) {
			this.r = r; this.c = c; this.dir = dir; this.color = color;
		}
	}
	
	static int bfs(int rs, int cs) {
		boolean[][][][] seen = new boolean[M][N][4][5]; // (row, col, dir, color)
		int[][][][] dist = new int[M][N][4][5];
		Queue<Item> Q = new LinkedList<Item>();
		
		seen[rs][cs][0][0] = true;
		dist[rs][cs][0][0] = 0;
		Q.offer(new Item(rs, cs, 0, 0));
		
		while (!Q.isEmpty()) {
			Item it = Q.poll();
			int r = it.r, c = it.c, dir = it.dir, color = it.color;
			if (grid[r][c] == 'T' && color == 0) return dist[r][c][dir][color];
			
			int ndir = (dir + 1) % 4;
			if (!seen[r][c][ndir][color]) {
				seen[r][c][ndir][color] = true;
				dist[r][c][ndir][color] = dist[r][c][dir][color] + 1;
				Q.offer(new Item(r, c, ndir, color));
			}
			ndir = (dir - 1 + 4) % 4;
			if (!seen[r][c][ndir][color]) {
				seen[r][c][ndir][color] = true;
				dist[r][c][ndir][color] = dist[r][c][dir][color] + 1;
				Q.offer(new Item(r, c, ndir, color));
			}
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			int ncolor = (color + 1) % 5;
			if (nr >= 0 && nc >= 0 && nr < M && nc < N && grid[nr][nc] != '#' &&
					!seen[nr][nc][dir][ncolor]) {
				seen[nr][nc][dir][ncolor] = true;
				dist[nr][nc][dir][ncolor] = dist[r][c][dir][color] + 1;
				Q.offer(new Item(nr, nc, dir, ncolor));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		int t = 1;
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			M = Integer.parseInt(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			
			if (M == 0 && N == 0) break;
			
			grid = new char[M][N];
			for (int i = 0; i < M; ++i)
				grid[i] = in.readLine().toCharArray();
			
			int ans = -2;
			for (int i = 0; i < M && ans == -2; ++i)
				for (int j = 0; j < N && ans == -2; ++j)
					if (grid[i][j] == 'S')
						ans = bfs(i, j);

			if (first) first = false; else System.out.println();
			System.out.println("Case #" + t);
			if (ans == -1)
				System.out.println("destination not reachable");
			else
				System.out.println("minimum time = " + ans + " sec");
			
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
