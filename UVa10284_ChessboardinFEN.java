package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1225 (10284 - Chessboard in FEN) */
/* SUBMISSION: 11507119 */
/* SUBMISSION TIME: 2013-03-25 20:39:53 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10284_ChessboardinFEN {
	
	static char[][] board;
	static boolean[][] attacked;
	
	static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < 8 && c < 8 && board[r][c] == '.';
	}

	static void attack(int r, int c, int[] dr, int[] dc, char ch) {
		if (ch == 'r' || ch == 'b' || ch == 'q')
			for (int d = 0; d < dr.length; ++d)
				for (int k = 1; valid(r + dr[d] * k, c + dc[d] * k); ++k)
					attacked[r + dr[d] * k][c + dc[d] * k] = true;
		else
			for (int d = 0; d < dr.length; ++d)
				if (valid(r + dr[d], c + dc[d])) 
					attacked[r + dr[d]][c + dc[d]] = true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, int[]> dr = new HashMap<Character, int[]>();
		Map<Character, int[]> dc = new HashMap<Character, int[]>();
		
		dr.put('p', new int[]{1, 1});
		dr.put('P', new int[]{-1, -1});
		dr.put('r', new int[]{-1, 0, 0, 1});
		dr.put('b', new int[]{-1, -1, 1, 1});
		dr.put('n', new int[]{-2, -2, -1, -1, 1, 1, 2, 2});
		dr.put('k', new int[]{-1, -1, -1, 0, 0, 1, 1, 1});
		dr.put('q', new int[]{-1, -1, -1, 0, 0, 1, 1, 1});
		
		dc.put('p', new int[]{-1, 1});
		dc.put('P', new int[]{-1, 1});
		dc.put('r', new int[]{0, -1, 1, 0});
		dc.put('b', new int[]{-1, 1, -1, 1});
		dc.put('n', new int[]{-1, 1, -2, 2, -2, 2, -1, 1});
		dc.put('k', new int[]{-1, 0, 1, -1, 1, -1, 0, 1});
		dc.put('q', new int[]{-1, 0, 1, -1, 1, -1, 0, 1});
		
		String line;
		while ((line = in.readLine()) != null) {
			if (line.isEmpty()) continue;
			String[] parts = line.split("/");
			
			board = new char[8][8];
			for (int i = 0; i < 8; ++i)
				for (int j = 0; j < 8; ++j)
					board[i][j] = '.';
			
			for (int i = 0; i < 8; ++i) {
				int j = 0;
				for (int k = 0; k < parts[i].length(); ++k) {
					char c = parts[i].charAt(k);
					if (c >= '0' && c <= '9')
						j += c - '0';
					else {
						board[i][j] = c;
						++j;
					}
				}
			}
			
			attacked = new boolean[8][8];
			for (int i = 0; i < 8; ++i)
				for (int j = 0; j < 8; ++j) {
					char ch = board[i][j];
					if (ch == '.') continue;
					if (ch != 'p' && ch != 'P') ch = Character.toLowerCase(ch);
					
					attack(i, j, dr.get(ch), dc.get(ch), ch);
				}
			int cnt = 0;
			for (int i = 0; i < 8; ++i)
				for (int j = 0; j < 8; ++j)
					if (board[i][j] == '.' && !attacked[i][j])
						++cnt;
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
