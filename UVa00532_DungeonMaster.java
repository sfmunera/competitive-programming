package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 473 (532 - Dungeon Master) */
/* SUBMISSION: 09049266 */
/* SUBMISSION TIME: 2011-07-14 19:58:33 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00532_DungeonMaster {
	
	static char[][][] maze;
	static int L, R, C;
	static int[] dl = {0, 0, 0, 0, 1, -1};
	static int[] dr = {0, 0, -1, 1, 0, 0};
	static int[] dc = {-1, 1, 0, 0, 0, 0};
	
	static boolean valid(int l, int r, int c) {
		return l >= 0 && l < L && r >= 0 && r < R && c >= 0 && c < C && maze[l][r][c] != '#';
	}
	
	static int[][][] bfs(int sl, int sr, int sc) {
		int[][][] distance = new int[L][R][C];
		boolean[][][] visited = new boolean[L][R][C];
		
		for (int l = 0; l < L; ++l)
			for (int r = 0; r < R; ++r)
				Arrays.fill(distance[l][r], -1);
		
		Queue<Integer> Ql = new LinkedList<Integer>();
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		
		visited[sl][sr][sc] = true;
		distance[sl][sr][sc] = 0;
		Ql.offer(sl);
		Qr.offer(sr);
		Qc.offer(sc);
		
		while (!Ql.isEmpty()) {
			int l = Ql.poll();
			int r = Qr.poll();
			int c = Qc.poll();
			
			for (int d = 0; d < dl.length; ++d) {
				int nl = l + dl[d];
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (valid(nl, nr, nc) && !visited[nl][nr][nc]) {
					distance[nl][nr][nc] = distance[l][r][c] + 1;
					visited[nl][nr][nc] = true;
					Ql.offer(nl);
					Qr.offer(nr);
					Qc.offer(nc);
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			L = Integer.parseInt(stk.nextToken());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			
			if (L == 0 && R == 0 && C == 0)
				break;
			
			maze = new char[L][R][C];
			
			for (int l = 0; l < L; ++l) {
				for (int r = 0; r < R; ++r)
					maze[l][r] = in.readLine().toCharArray();
				in.readLine();
			}
			int l1 = 0, r1 = 0, c1 = 0;
			int l2 = 0, r2 = 0, c2 = 0;
			
			for (int l = 0; l < L; ++l)
				for (int r = 0; r < R; ++r)
					for (int c = 0; c < C; ++c) {
						if (maze[l][r][c] == 'S') {
							l1 = l;
							r1 = r;
							c1 = c;
						}
						if (maze[l][r][c] == 'E') {
							l2 = l;
							r2 = r;
							c2 = c;
						}
					}
			int[][][] distance = bfs(l1, r1, c1);
			if (distance[l2][r2][c2] == -1)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in " + distance[l2][r2][c2] + " minute(s).");
		}
		
		in.close();
		System.exit(0);
	}
}