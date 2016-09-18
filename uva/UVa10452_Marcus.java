package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1393 (10452 - Marcus) */
/* SUBMISSION: 10591770 */
/* SUBMISSION TIME: 2012-09-11 20:48:34 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10452_Marcus {
	
	static char[][] board;
	static int N, M;
	static String  next = "IEHOVA#";
	static int[] dr = {0, -1, 0};
	static int[] dc = {-1, 0, 1};
	static String[] dir = {"left", "forth", "right"};
	static List<String> path;
	
	static boolean inside(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}
	
	static void dfs(int r, int c, int nxt) {
		for (int d = 0; d < 3; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (inside(nr, nc) && board[nr][nc] == next.charAt(nxt)) {
				path.add(dir[d]);
				if (board[nr][nc] != '#')
					dfs(nr, nc, nxt + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			M = Integer.parseInt(parts[0]);
			N = Integer.parseInt(parts[1]);
			
			board = new char[M][N];
			for (int i = 0; i < M; ++i)
				board[i] = in.readLine().toCharArray();
			
			int r = -1;
			int c = -1;
			for (int i = 0; i < M; ++i)
				for (int j = 0; j < N; ++j)
					if (board[i][j] == '@') {
						r = i;
						c = j;
					}
			
			path = new ArrayList<String>();
			dfs(r, c, 0);
			
			for (int i = 0; i < path.size(); ++i) {
				if (i > 0) System.out.print(" ");
				System.out.print(path.get(i));
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
