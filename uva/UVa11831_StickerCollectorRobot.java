package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2931 (11831 - Sticker Collector Robot) */
/* SUBMISSION: 10931904 */
/* SUBMISSION TIME: 2012-11-24 13:18:52 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11831_StickerCollectorRobot {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			int S = Integer.parseInt(parts[2]);
			
			if (R == 0 && C == 0 && S == 0) break;
			
			int[] dr = {-1, 0, 1, 0}; // N E S W
			int[] dc = {0, 1, 0, -1};
			String dirs = "NLSO";
			char[][] map = new char[R][C];
			for (int i = 0; i < R; ++i)
				map[i] = in.readLine().toCharArray();
			char[] path = in.readLine().toCharArray();
			
			int r = -1;
			int c = -1;
			int dir = -1;
			for (int i = 0; i < R && r == -1 && c == -1; ++i)
				for (int j = 0; j < C && r == -1 && c == -1; ++j)
					if (map[i][j] == 'N' || map[i][j] == 'S' || map[i][j] == 'L' || map[i][j] == 'O') {
						r = i;
						c = j;
						dir = dirs.indexOf(map[i][j]);
					}
			int cnt = 0;
			for (int i = 0; i < S; ++i) {
				if (path[i] == 'D')
					dir = (dir + 1) % 4;
				else if (path[i] == 'E') {
					--dir;
					if (dir < 0)
						dir = 3;
				} else if (path[i] == 'F') {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != '#') {
						r = nr;
						c = nc;
						if (map[r][c] == '*') {
							++cnt;
							map[r][c] = '.';
						}
					}
				}
			}
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
