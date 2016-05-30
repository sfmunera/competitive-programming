package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 723 (782 - Contour Painting) */
/* SUBMISSION: 10326875 */
/* SUBMISSION TIME: 2012-07-12 20:34:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00782_ContourPainting {
	
	static int R, C;
	static char[][] A;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static boolean isContour(char c) {
		return c != '#' && c != '*' && c != '_' && c != ' ';
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		boolean paint = false;
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (inside(nr, nc) && isContour(A[nr][nc]))
				paint = true;
		}
		if (paint)
			A[r][c] = '#';
		
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (inside(nr, nc) && !visited[nr][nc] && A[nr][nc] == ' ')
				dfs(nr, nc);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			List<String> lines = new ArrayList<String>();
			String separator = "";
			R = 0;
			C = 0;
			while (true) {
				String line = in.readLine();
				if (line.startsWith("_")) {
					separator = line;
					break;
				}
				
				lines.add(line);
				C = Math.max(C, line.length());
			}
			R = lines.size();
			++C;
			
			A = new char[R][C];
			visited = new boolean[R][C];
			for (int i = 0; i < R; ++i) {
				int len = lines.get(i).length();
				
				for (int j = 0; j < len; ++j)
					A[i][j] = lines.get(i).charAt(j);
				for (int j = len; j < C; ++j)
					A[i][j] = ' ';
			}
			
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					if (A[i][j] == '*') {
						A[i][j] = ' ';
						dfs(i, j);
						break;
					}
			
			for (int i = 0; i < R; ++i) {
				int pos = 0;
				for (int j = 0; j < C; ++j)
					if (A[i][j] != ' ')
						pos = j + 1;
				for (int j = 0; j < pos; ++j)
					sb.append(A[i][j]);
				sb.append("\n");
			}
			sb.append(separator + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
