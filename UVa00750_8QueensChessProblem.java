package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 691 (750 - 8 Queens Chess Problem) */
/* SUBMISSION: 11374902 */
/* SUBMISSION TIME: 2013-03-03 15:27:47 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00750_8QueensChessProblem {
	
	static int[] rows;
	static int r, c, cnt;
	
	static boolean valid(int col, int row) {
		for (int c = 1; c < col; ++c)
			if (rows[c] == row || Math.abs(rows[c] - row) == Math.abs(c - col))
				return false;
		return true;
	}
	
	static void go(int col) {
		if (col > 8 && rows[c] == r) {
			System.out.printf("%2d     ", cnt++);
			for (int i = 1; i <= 8; ++i)
				System.out.print(" " + rows[i]);
			System.out.println();
			return;
		}
		for (int row = 1; row <= 8; ++row) {
			if (valid(col, row)) {
				rows[col] = row;
				go(col + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			stk = new StringTokenizer(in.readLine());
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			
			if (first) first = false; else System.out.println();
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			
			rows = new int[9];
			cnt = 1;
			go(1);
		}
		
		in.close();
		System.exit(0);
	}
}
