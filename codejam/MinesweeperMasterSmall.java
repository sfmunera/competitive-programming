package codejam;

import java.io.*;
import java.util.*;

public class MinesweeperMasterSmall {
	
	static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static boolean[][] seen;
	static int[][] field;
	static int R, C;
	
	static boolean inside(int i, int j) {
		return i >= 0 && j >= 0 && i < R && j < C;
	}
	
	static int dfs(int i, int j) {
		seen[i][j] = true;
		
		int cnt = 0;
		if (field[i][j] == 0)
			for (int d = 0; d < 8; ++d) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				if (inside(nr, nc) && !seen[nr][nc] && field[nr][nc] != -1)
					cnt += dfs(nr, nc);
			}
		
		return 1 + cnt;
	}
	
	static int[][] buildField(int mask, int R, int C) {
		int[][] field = new int[R][C];
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				if ((mask & (1 << (i * C + j))) > 0)
					field[i][j] = -1;
		
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				if (field[i][j] == -1)
					for (int d = 0; d < 8; ++d) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (inside(nr, nc) && field[nr][nc] != -1)
							++field[nr][nc];
					}
		
		return field;
	}
	
	static void printField(int[][] field, int r, int c) {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j)
				if (i == r && j == c)
					System.out.print("c");
				else if (field[i][j] == -1)
					System.out.print("*");
				else
					System.out.print(".");
			System.out.println();
		}
	}
	
	static void printField2(int[][] field) {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j)
				System.out.print(field[i][j] == -1 ? "*" : field[i][j]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-small.in"));
		System.setOut(new PrintStream("C-small.out"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			R = in.nextInt();
			C = in.nextInt();
			int M = in.nextInt();
			
			System.out.println("Case #" + t + ":");
			
			boolean done = false;
			for (int mask = 0; mask < (1 << (R * C)) && !done; ++mask)
				if (Integer.bitCount(mask) == M) {
					field = buildField(mask, R, C);
					//printField2(field);
					for (int i = 0; i < R && !done; ++i)
						for (int j = 0; j < C && !done; ++j)
							if (field[i][j] >= 0) {
								seen = new boolean[R][C];
								if (dfs(i, j) == R * C - M) {
									done = true;
									printField(field, i, j);
									break;
								}
							}
				}
			
			if (!done)
				System.out.println("Impossible");
		}
		
		in.close();
		System.exit(0);
	}
}
