package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2258 (11283 - Playing Boggle) */
/* SUBMISSION: 11412889 */
/* SUBMISSION TIME: 2013-03-10 04:00:03 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11283_PlayingBoggle {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static boolean[][] visited;
	static char[][] board;
	
	static boolean dfs(String word, int i, int r, int c) {
		if (word.charAt(i) != board[r][c]) return false;
		if (i == word.length() - 1) return true;
		
		boolean ans = false;
		for (int j = 0; j < 8; ++j) {
			int nr = r + dr[j];
			int nc = c + dc[j];
			if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && 
					!visited[nr][nc]) {
				visited[nr][nc] = true;
				ans |= dfs(word, i + 1, nr, nc);
				visited[nr][nc] = false;
			}
		}
		return ans;
	}
	
	static int score(String s) {
		int N = s.length();
		if (N == 3 || N == 4) return 1;
		if (N == 5) return 2;
		if (N == 6) return 3;
		if (N == 7) return 5;
		if (N >= 8) return 11;
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			board = new char[4][4];
			for (int i = 0; i < 4; ++i)
				board[i] = in.next().toCharArray();
			
			int M = in.nextInt();
			int score = 0;
			for (int i = 0; i < M; ++i) {
				String word = in.next();
				boolean found = false;
				for (int r = 0; r < 4 && !found; ++r)
					for (int c = 0; c < 4 && !found; ++c) {
						visited = new boolean[4][4];
						visited[r][c] = true;
						if (dfs(word, 0, r, c)) {
							found = true;
							score += score(word);
						}
					}
			}
			System.out.println("Score for Boggle game #" + t + ": " + score);
		}
		
		in.close();
		System.exit(0);
	}
}
