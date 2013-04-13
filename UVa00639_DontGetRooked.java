package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 580 (639 - Don't Get Rooked) */
/* SUBMISSION: 09027920 */
/* SUBMISSION TIME: 2011-07-07 22:33:23 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00639_DontGetRooked {
	
	static boolean attacked(char[][] b, int r, int c) {
		int n = b.length;
		
		for (int k = c; k >= 0; --k) {
			if (b[r][k] == 'X')
				break;
			if (b[r][k] == 'R')
				return true;
		}
		for (int k = c; k < n; ++k) {
			if (b[r][k] == 'X')
				break;
			if (b[r][k] == 'R')
				return true;
		}
		
		for (int k = r; k >= 0; --k){
			if (b[k][c] == 'X')
				break;
			if (b[k][c] == 'R')
				return true;
		}
		for (int k = r; k < n; ++k) {
			if (b[k][c] == 'X')
				break;
			if (b[k][c] == 'R')
				return true;
		}
		
		return false;
	}
		
	static int solve(char[][] b) {
		int n = b.length;
		
		int max = 0;
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j) {
				if (b[i][j] != '.' || attacked(b, i, j))
					continue;
				b[i][j] = 'R';
				max = Math.max(max, 1 + solve(b));
				b[i][j] = '.';
			}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			char[][] board = new char[n][n];
			for (int i = 0; i < n; ++i)
				board[i] = in.next().toCharArray();
			
			System.out.println(solve(board));
		}
	}
}