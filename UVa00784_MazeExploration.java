package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 725 (784 - Maze Exploration) */
/* SUBMISSION: 09040322 */
/* SUBMISSION TIME: 2011-07-11 22:58:31 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00784_MazeExploration {
	
	static int R, C;
	static char[][] maze;
	
	static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C && maze[r][c] == ' ';
	}
	
	static void dfs(int r, int c) {
		if (!valid(r, c))
			return;
		
		maze[r][c] = '#';
		dfs(r - 1, c);
		dfs(r + 1, c);
		dfs(r, c - 1);
		dfs(r, c + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			List<String> mazeStr = new ArrayList<String>();
			String sep = "";
			R = 0;
			C = 0;
			
			while (true) {
				String line = in.readLine();
				if (line.charAt(0) == '_') {
					sep = line;
					break;
				}
				mazeStr.add(line);
				++R;
				C = Math.max(C, line.length());
			}
			
			maze = new char[R][C];
			for (int i = 0; i < R; ++i)
				Arrays.fill(maze[i], ' ');
			for (int i = 0; i < R; ++i) {
				char[] tmp =  mazeStr.get(i).toCharArray();
				for (int j = 0; j < tmp.length; ++j)
					maze[i][j] = tmp[j];
			}
			
			boolean done = false;
			for (int i = 0; i < R && !done; ++i)
				for (int j = 0; j < C && !done; ++j)
					if (maze[i][j] == '*') {
						maze[i][j] = ' ';
						dfs(i, j);
						done = true;
					}
			for (int i = 0; i < R; ++i)
				System.out.println(String.valueOf(maze[i]).trim());
			System.out.println(sep);
		}
		
		in.close();
		System.exit(0);
	}
}