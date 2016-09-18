package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 103 (167 - The Sultan's Successors) */
/* SUBMISSION: 11375008 */
/* SUBMISSION TIME: 2013-03-03 15:46:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00167_TheSultansSuccessors {
	
	static int[][] board;
	static int[] rows;
	static int ans;
	
	static boolean valid(int col, int row) {
		for (int c = 0; c < col; ++c)
			if (rows[c] == row || Math.abs(rows[c] - row) == Math.abs(c - col))
				return false;
		return true;
	}
	
	static void go(int col, int sum) {
		if (col == 8) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int row = 0; row < 8; ++row)
			if (valid(col, row)) {
				rows[col] = row;
				go(col + 1, sum + board[row][col]);
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int k = Integer.parseInt(in.readLine());
		while (k-- > 0) {
			board = new int[8][8];
			for (int i = 0; i < 8; ++i) {
				stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; ++j)
					board[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			rows = new int[8];
			ans = 0;
			go(0, 0);
			System.out.printf("%5d\n", ans);
		}
		
		in.close();
		System.exit(0);
	}
}
