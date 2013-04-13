package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1318 (10377 - Maze Traversal) */
/* SUBMISSION: 11413120 */
/* SUBMISSION TIME: 2013-03-10 05:06:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10377_MazeTraversal {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		String dirs = "NWSE";
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		
		boolean first = true;
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			char[][] map = new char[R][C];
			for (int i = 0; i < R; ++i)
				map[i] = in.readLine().toCharArray();
			stk = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(stk.nextToken()) - 1;
			int c = Integer.parseInt(stk.nextToken()) - 1;
			
			String line;
			String commands = "";
			while ((line = in.readLine()) != null && !line.isEmpty())
				commands += line;
			
			int dir = 0;
			if (first) first = false; else System.out.println();
			for (int i = 0; i < commands.length(); ++i) {
				if (commands.charAt(i) == ' ') continue;
				if (commands.charAt(i) == 'L') dir = (dir + 1) % 4;
				else if (commands.charAt(i) == 'R') {
					--dir;
					if (dir < 0) dir = 3;
				} else if (commands.charAt(i) == 'F') {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != '*') {
						r = nr;
						c = nc;
					}
				} else if (commands.charAt(i) == 'Q') {
					System.out.println((r + 1) + " " + (c + 1) + " " + dirs.charAt(dir));
					break;
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}
