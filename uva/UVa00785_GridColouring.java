package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 726 (785 - Grid Colouring) */
/* SUBMISSION: 09040402 */
/* SUBMISSION TIME: 2011-07-12 00:18:50 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00785_GridColouring {
	
	static int R;
	static char[][] maze;
	static boolean[][] visited;
	
	static boolean valid(int r, int c, char contour) {
		return r >= 0 && c >= 0 && r < R && c < maze[r].length && 
			maze[r][c] != contour && !visited[r][c];  
	}
	
	static void dfs(int r, int c, char contour, char mark) {
		if (!valid(r, c, contour))
			return;
		
		visited[r][c] = true;
		maze[r][c] = mark;
		dfs(r - 1, c, contour, mark);
		dfs(r + 1, c, contour, mark);
		dfs(r, c - 1, contour, mark);
		dfs(r, c + 1, contour, mark);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while (true) {
			maze = new char[35][85];
			visited = new boolean[35][85];
			String sep = "";
			
			R = 0;
			
			while (true) {
				line = in.readLine();
				if (line == null)
					break;
				if (!line.isEmpty() && line.charAt(0) == '_') {
					sep = line;
					break;
				}
				maze[R] = line.toCharArray();
				++R;
			}
			if (line == null)
				break;
			
			char contour = ' ';
			boolean found = false;;
			for (int i = 0; i < R && !found; ++i)
				for (int j = 0; j < maze[i].length && !found; ++j)
					if (maze[i][j] != ' ' && maze[i][j] != '_') {
						contour = maze[i][j];
						found = true;
					}
			
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < maze[i].length; ++j)
					if (maze[i][j] != ' ' && maze[i][j] != contour && !visited[i][j])
						dfs(i, j, contour, maze[i][j]);
			
			for (int i = 0; i < R; ++i)
				System.out.println(maze[i]);
			System.out.println(sep);
		}
		
		in.close();
		System.exit(0);
	}
}