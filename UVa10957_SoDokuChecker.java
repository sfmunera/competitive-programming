package uva;

import java.io.*;
import java.util.*;

public class UVa10957_SoDokuChecker {
	
	static int[] takenRows;
	static int[] takenCols;
	static int[][] takenSquares;
	static int[][] board;
	static boolean[][] fixed;
	static int cnt;
	static int n = 3;
	
	static boolean valid(int[][] b) {
		boolean[] seen;
		// check rows
		for (int i = 0; i < 9; ++i) {
			seen = new boolean[10];
			for (int j = 0; j < 9; ++j) {
				if (b[i][j] > 0 && seen[b[i][j]])
					return false;
				seen[b[i][j]]= true;
			}
		}
		// check cols
		for (int j = 0; j < 9; ++j) {
			seen = new boolean[10];
			for (int i = 0; i < 9; ++i) {
				if (b[i][j] > 0 && seen[b[i][j]])
					return false;
				seen[b[i][j]]= true;
			}
		}
		// check squares
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				seen = new boolean[10];
				for (int k = i; k < i + 3; ++k)
					for (int l = j; l < j + 3; ++l) {
						if (b[k][l] > 0 && seen[b[k][l]])
							return false;
						seen[b[k][l]]= true;
					}
			}
		}
		return true;
	}
	
	static int setBit(int x, int i) {
		return x | (1 << i);
	}
	static int clearBit(int x, int i) {
		return x & ~(1 << i);
	}
	static boolean isSetBit(int x, int i) {
		return (x & (1 << i)) > 0;
	}
	
	static boolean validPosition(int r, int c, int x) {
		if (isSetBit(takenRows[r], x) || 
			isSetBit(takenCols[c], x) || 
			isSetBit(takenSquares[r / n][c / n], x))
			return false;
		return true;
	}
	
	static void setPosition(int r, int c, int x) {
		takenRows[r] = setBit(takenRows[r], x);
		takenCols[c] = setBit(takenCols[c], x);
		takenSquares[r / n][c / n] = setBit(takenSquares[r / n][c / n], x);
		board[r][c] = x;
	}
	
	static void clearPosition(int r, int c, int x) {
		takenRows[r] = clearBit(takenRows[r], x);
		takenCols[c] = clearBit(takenCols[c], x);
		takenSquares[r / n][c / n] = clearBit(takenSquares[r / n][c / n], x);
		board[r][c] = 0;
	}
	
	static void go(int r, int c) {
		if (cnt > 1) return;
		if (r >= n * n) {
			++cnt;
			return;
		}
		int nextr = c + 1 < n * n ? r : r + 1;
		int nextc = (c + 1) % (n * n);
		if (fixed[r][c]) {
			go(nextr, nextc);
			return;
		}
		for (int i = 1; i <= n * n; ++i)
			if (validPosition(r, c, i)) {
				setPosition(r, c, i);
				go(nextr, nextc);
				clearPosition(r, c, i);
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		while (true) {
			String line = in.readLine();
			if (line == null) break;
			
			board = new int[n * n][n * n];
			for (int i = 0; i < n * n; ++i) {
				StringTokenizer stk = new StringTokenizer(line);
				for (int j = 0; j < n * n; ++j)
					board[i][j] = Integer.parseInt(stk.nextToken());
				line = in.readLine();
			}
			
			takenRows = new int[n * n];
			takenCols = new int[n * n];
			takenSquares = new int[n][n];
			fixed = new boolean[n * n][n * n];
			
			cnt = 0;
			for (int i = 0; i < n * n; ++i)
				for (int j = 0; j < n * n; ++j)
					if (board[i][j] > 0) {
						fixed[i][j] = true;
						setPosition(i, j, board[i][j]);
					}
			System.out.print("Case " + t + ": ");
			if (!valid(board))
				System.out.println("Illegal.");
			else {
				go(0, 0);
				if (cnt == 0)
					System.out.println("Impossible.");
				else if (cnt == 1)
					System.out.println("Unique.");
				else
					System.out.println("Ambiguous.");
			}
			++t;
		}
	}
}
