package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 793 (852 - Deciding victory in Go) */
/* SUBMISSION: 09432695 */
/* SUBMISSION TIME: 2011-11-02 01:20:15 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00852_DecidingvictoryinGo {
	
	static int[] dc = {-1, 0, 0, 1};
	static int[] dr = {0, -1, 1, 0};
	
	static char[][] board1, board2;
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < 9 && c < 9;
	}
	
	static void dfs1(int r, int c, char type) {
		if (!inside(r, c))
			return;
		if (board1[r][c] != '.')
			return;
		
		board1[r][c] = type;
		
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			dfs1(nr, nc, type);
		}
	}
	
	static void dfs2(int r, int c, char type) {
		if (!inside(r, c))
			return;
		if (board2[r][c] != '.')
			return;
		
		board2[r][c] = type;
		
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			dfs2(nr, nc, type);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			board1 = new char[9][9];
			board2 = new char[9][9];
			
			for (int i = 0; i < 9; ++i) {
				board1[i] = in.readLine().toCharArray();
				board2[i] = board1[i].clone();
			}
			
			for (int i = 0; i < 9; ++i)
				for (int j = 0; j < 9; ++j) {
					if (board1[i][j] == 'O')
						for (int d = 0; d < 4; ++d) {
							int ni = i + dr[d];
							int nj = j + dc[d];
							if (inside(ni, nj) && board1[ni][nj] == '.')
								dfs1(ni, nj, 'O');
						}
					if (board2[i][j] == 'X')
						for (int d = 0; d < 4; ++d) {
							int ni = i + dr[d];
							int nj = j + dc[d];
							if (inside(ni, nj) && board2[ni][nj] == '.')
								dfs2(ni, nj, 'X');
						}
				}
			
			/*System.out.println("Board 1:");
			for (int i = 0; i < 9; ++i)
				System.out.println(Arrays.toString(board1[i]));
			System.out.println("Board 2:");
			for (int i = 0; i < 9; ++i)
				System.out.println(Arrays.toString(board2[i]));*/
			
			int cntBlack = 0;
			int cntWhite = 0;
			for (int i = 0; i < 9; ++i)
				for (int j = 0; j < 9; ++j) {
					if ((board1[i][j] == '.' && board2[i][j] == 'O') || 
						(board1[i][j] == 'O' && board2[i][j] == '.') ||
						(board1[i][j] == 'O' && board2[i][j] == 'O'))
						++cntWhite;
					if ((board1[i][j] == '.' && board2[i][j] == 'X') || 
						(board1[i][j] == 'X' && board2[i][j] == '.') ||
						(board1[i][j] == 'X' && board2[i][j] == 'X'))
						++cntBlack;
				}
			System.out.println("Black " + cntBlack + " White " + cntWhite + "");
			
		}
		
		in.close();
		System.exit(0);
	}
}