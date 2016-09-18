package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 497 (556 - Amazing) */
/* SUBMISSION: 11502783 */
/* SUBMISSION TIME: 2013-03-24 23:58:28 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00556_Amazing {
	
	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			
			if (R == 0 && C == 0)
				break;
			
			boolean[][] board = new boolean[R + 2][C + 2];
			int[][] cnt = new int[R + 2][C + 2];
			
			for (int i = 0; i < R + 2; ++i)
				board[i][0] = board[i][C + 1] = true;
			
			for (int j = 0; j < C + 2; ++j)
				board[0][j] = board[R + 1][j] = true;
			
			for (int i = 0; i < R; ++i) {
				char[] line = in.readLine().toCharArray();
				for (int j = 0; j < C; ++j)
					if (line[j] == '1')
						board[i + 1][j + 1] = true;
			}
			
			int r0 = R;
			int c0 = 1;
			int dir = 0; // 0: EAST, 1: NORTH, 2: WEST, 3: SOUTH
			
			while (true) {
				int nr = r0 + dr[dir];
				int nc = c0 + dc[dir];
				
				int ndir = dir - 1 == -1 ? 3 : dir - 1;
				int sr = r0 + dr[ndir];
				int sc = c0 + dc[ndir];
				
				if (board[sr][sc]) { // If there is wall to the right
					if (!board[nr][nc]) { // If can move forward in same dir
						++cnt[r0][c0];
						r0 = nr;
						c0 = nc;
					} else { // If cannot move forward in same dir
						dir = (dir + 1) % 4; // Turn to the left
					}
				} else { // If there is not wall to the right
					dir = ndir;
					++cnt[r0][c0];
					r0 = sr;
					c0 = sc;
				}
				
				if (r0 == R && c0 == 1)
					break;
			}
			
			int[] res = new int[5];
			for (int i = 1; i <= R; ++i)
				for (int j = 1; j <= C; ++j)
					if (!board[i][j] && cnt[i][j] < 5)
						++res[cnt[i][j]];
			System.out.printf("%3d%3d%3d%3d%3d\n", res[0], res[1], res[2], res[3], res[4]);
		}
			
		in.close();
		System.exit(0);
	}
}
