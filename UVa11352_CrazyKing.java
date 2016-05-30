package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2327 (11352 - Crazy King) */
/* SUBMISSION: 10347844 */
/* SUBMISSION TIME: 2012-07-17 19:54:13 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11352_CrazyKing {
	
	// Horse moves
	static int[] drh = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dch = {-1, 1, -2, 2, -2, 2, -1, 1};
	// King moves
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int R, C;
	static char[][] field;
	
	static boolean inside(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static int bfs(int sr, int sc) {
		boolean[][] visited = new boolean[R][C];
		int[][] dist = new int[R][C];
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		
		for (int i = 0; i < R; ++i)
			Arrays.fill(dist[i], -1);
		
		visited[sr][sc] = true;
		dist[sr][sc] = 0;
		Qr.offer(sr);
		Qc.offer(sc);
		
		while (!Qr.isEmpty()) {
			int r = Qr.poll();
			int c = Qc.poll();
			if (field[r][c] == 'B')
				return dist[r][c];
			
			for (int k = 0; k < dr.length; ++k) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (inside(nr, nc) && !visited[nr][nc] && field[nr][nc] != 'Z' && field[nr][nc] != 'K') {
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
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			R = Integer.parseInt(parts[0]);
			C = Integer.parseInt(parts[1]);
			field = new char[R][C];
			
			for (int i = 0; i < R; ++i)
				field[i] = in.readLine().toCharArray();
			
			int Ar = 0;
			int Ac = 0;
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					if (field[i][j] == 'Z') {
						for (int k = 0; k < drh.length; ++k) {
							int nr = i + drh[k];
							int nc = j + dch[k];
							if (inside(nr, nc) && field[nr][nc] == '.')
								field[nr][nc] = 'K';
						}
					} else if (field[i][j] == 'A') {
						Ar = i;
						Ac = j;
					}
			int dist = bfs(Ar, Ac);
			
			if (dist == -1)
				System.out.println("King Peter, you can't go now!");
			else
				System.out.println("Minimal possible length of a trip is " + dist);
		}
		
		in.close();
		System.exit(0);
	}
}
