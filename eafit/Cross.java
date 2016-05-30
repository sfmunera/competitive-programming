package eafit;

import java.io.*;
import java.util.*;

public class Cross {
	
	static boolean valid(char[][] board) {
		int[] cnt = new int[9];
		
		for (int i = 0; i < 9; ++i) {
			cnt = new int[9];
			for (int j = 0; j < 9; ++j)
				if (board[i][j] != '.')
					++cnt[board[i][j] - '0' - 1];
		}
		for (int i = 0; i < 9; ++i)
			if (cnt[i] > 1)
				return false;
		
		for (int i = 0; i < 9; ++i) {
			cnt = new int[9];
			for (int j = 0; j < 9; ++j)
				if (board[j][i] != '.')
					++cnt[board[j][i] - '0' - 1];
		}
		for (int i = 0; i < 9; ++i)
			if (cnt[i] > 1)
				return false;
		
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				cnt = new int[9];
				for (int a = 0; a < 3; ++a)
					for (int b = 0; b < 3; ++b)
						if (board[i + a][j + b] != '.')
							++cnt[board[i + a][j + b] - '0' - 1];
				for (int k = 0; k < 9; ++k)
					if (cnt[k] > 1)
						return false;
			}
		}
		
		
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; ++i)
			board[i] = in.readLine().toCharArray();
		
		
		
		boolean valid = true;
		boolean finished = false;
		while (!finished) {
			char[][] prev = new char[9][9];
			for (int j = 0; j < 9; ++j) {
				prev[j] = board[j].clone();
			}
			
			for (int i = 1; i <= 9; ++i) {
				if (!valid(board)) {
					
					finished = true;
					valid = false;
					break;
				}
				boolean[] allowedCol = new boolean[9];
				boolean[] allowedRow = new boolean[9];
				boolean[][] allowedBox = new boolean[3][3];
				Arrays.fill(allowedCol, true);
				Arrays.fill(allowedRow, true);
				
				for (int j = 0; j < 3; ++j)
					Arrays.fill(allowedBox[j], true);
				
				int cnt = 0;
				for (int j = 0; j < 9; ++j)
					for (int k = 0; k < 9; ++k)
						if (board[j][k] - '0' == i) {
							++cnt;
							allowedCol[k] = false;
							allowedRow[j] = false;
							allowedBox[j / 3][k / 3] = false;
						}
				if (cnt == 9)
					continue;
				
				int r = -1;
				int c = -1;
				valid = false;
				for (int j = 0; j < 9 && !finished; j += 3)
					for (int k = 0; k < 9 && !finished; k += 3) {
						int cnt2 = 0;
						cnt = 0;
						for (int a = 0; a < 3; ++a)
							for (int b = 0; b < 3; ++b) {
								if (board[j + a][k + b] - '0' == i)
									++cnt2;
								if (board[j + a][k + b] == '.' && allowedCol[k + b] &&
										allowedRow[j + a] && allowedBox[j / 3][k / 3]) {
									++cnt;
									r = j + a;
									c = k + b;
								}
							}
						
						if (cnt2 == 0 && cnt >= 1) {
							valid = true;
							if (cnt == 1) {
								
								board[r][c] = (char)(i + '0');
								allowedRow[r] = false;
								allowedCol[c] = false;
								allowedBox[r / 3][c / 3] = false;
							}
						} else if (cnt2 == 0 && cnt == 0) {
							finished = true;
							valid = false;
						}
					}
				if (!valid) {
					
					finished = true;
					break;
				}
			}
			if (!valid) {
				
				finished = true;
				break;
			}
			boolean changed = false;
			for (int j = 0; j < 9; ++j)
				for (int k = 0; k < 9; ++k)
					if (prev[j][k] != board[j][k])
						changed = true;
			if (!changed) {
				valid = true;
				finished = true;
				break;
			}
		}
		
		if (!valid)
			System.out.println("ERROR");
		else {
			for (int i = 0; i < 9; ++i)
				System.out.println(board[i]);
		}
		in.close();
		System.exit(0);
	}
}
