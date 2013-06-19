
package uva;

import java.io.*;
import java.util.*;

public class UVa00989_Sudoku {
	
	static int[] takenRows;
	static int[] takenCols;
	static int[][] takenSquares;
	static int[][] board;
	static boolean[][] fixed;
	static boolean done;
	static int n;
	
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
	
	static void printSolution() {
		for (int i = 0; i < n * n; ++i) {
			for (int j = 0; j < n * n; ++j) {
				if (j > 0) System.out.print(" ");
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void go(int r, int c) {
		if (done) return;
		if (r >= n * n) {
			done = true;
			printSolution();
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
		
		boolean first = true;
		
		while (true) {
			if (!first) in.readLine();
			
			String line = in.readLine();
			if (line == null) break;
			n = Integer.parseInt(line);
			
			board = new int[n * n][n * n];
			for (int i = 0; i < n * n; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < n * n; ++j)
					board[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			takenRows = new int[n * n];
			takenCols = new int[n * n];
			takenSquares = new int[n][n];
			fixed = new boolean[n * n][n * n];
			
			done = false;
			for (int i = 0; i < n * n; ++i)
				for (int j = 0; j < n * n; ++j)
					if (board[i][j] > 0) {
						fixed[i][j] = true;
						setPosition(i, j, board[i][j]);
					}
			if (first) first = false; else System.out.println();
			go(0, 0);
			if (!done) System.out.println("NO SOLUTION");
		}
	}
}
