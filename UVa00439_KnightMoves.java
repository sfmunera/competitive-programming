package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 380 (439 - Knight Moves) */
/* SUBMISSION: 09049190 */
/* SUBMISSION TIME: 2011-07-14 19:32:21 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00439_KnightMoves {
	
	static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < 8 && c < 8;
	}
	
	static int[][] bfs(int r, int c) {
		int[][] distance = new int[8][8];
		boolean[][] visited = new boolean[8][8];
		
		for (int i = 0; i < 8; ++i)
			Arrays.fill(distance[i], -1);
		
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		
		distance[r][c] = 0;
		visited[r][c] = true;
		Qr.offer(r);
		Qc.offer(c);
		
		while (!Qr.isEmpty()) {
			int i = Qr.poll();
			int j = Qc.poll();
			
			for (int d = 0; d < 8; ++d) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				if (inside(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					distance[nr][nc] = distance[i][j] + 1;
					Qr.offer(nr);
					Qc.offer(nc);
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] squares = line.split("[ ]");
			int c1 = squares[0].charAt(0) - 'a';
			int r1 = squares[0].charAt(1) - '1';
			int c2 = squares[1].charAt(0) - 'a';
			int r2 = squares[1].charAt(1) - '1';
			
			int[][] distance = bfs(r1, c1);
			System.out.println("To get from " + squares[0] + " to " + squares[1] + 
					" takes " + distance[r2][c2] + " knight moves.");
		}
	}
}