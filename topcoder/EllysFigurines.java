package topcoder;

import java.util.*;

public class EllysFigurines {

	int min;
	int r, c, R, C;
	
	void go(int cnt, char[][] b) {

		boolean done = true;
		for (int i = 0; i < r; ++i)
			for (int j = 0; j < c; ++j)
				done &= b[i][j] == '.';
		if (done) {
			min = Math.min(min, cnt);
			return;
		}
		
		for (int i = 0; i < r; ++i) {
			char[][] b2 = new char[r][c];
			for (int j = 0; j < r; ++j)
				for (int k = 0; k < c; ++k)
					b2[j][k] = b[j][k];
			boolean has = false;
			for (int j = 0; j < c; ++j)
				has |= b2[i][j] == 'X';
			if (has) {
				for (int j = 0; j < R && i + j < r; ++j)
					for (int k = 0; k < c; ++k)
						b2[i + j][k] = '.';
				go(cnt + 1, b2);
			}
		}
		for (int i = 0; i < c; ++i) {
			char[][] b2 = new char[r][c];
			for (int j = 0; j < r; ++j)
				for (int k = 0; k < c; ++k)
					b2[j][k] = b[j][k];
			boolean has = false;
			for (int j = 0; j < r; ++j)
				has |= b2[j][i] == 'X';
			if (has) {
				for (int j = 0; j < C && i + j < c; ++j)
					for (int k = 0; k < r; ++k)
						b2[k][i + j] = '.';
				go(cnt + 1, b2);
			}
		}
	}
	
    public int getMoves(String[] board, int _R, int _C) {
    	r = board.length;
    	c = board[0].length();
    	R = _R;
    	C = _C;
        char[][] b = new char[r][c];
        
        for (int i = 0; i < r; ++i)
        	b[i] = board[i].toCharArray();

        min = Integer.MAX_VALUE;
        go(0, b);
        
        return min;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EllysFigurines.class, "test.*");
    }

	public void test0() {
		RETester.eq(getMoves(new String[] {
			".X.X.",
			"XX..X",
			".XXX.",
			"...X.",
			".X.XX"},
			1, 2), 3);
	}

	public void test1() {
		RETester.eq(getMoves(new String[] {
			".X.X.",
			"XX..X",
			".X.X.",
			"...X.",
			".X.XX"},
			2, 2), 2);
	}

	public void test2() {
		RETester.eq(getMoves(new String[] {"XXXXXXX"}, 2, 3), 1);
	}

	public void test3() {
		RETester.eq(getMoves(new String[] {
			"XXXXX",
			"X....",
			"XXX..",
			"X....",
			"XXXXX"},
			1, 1), 4);
	}

	public void test4() {
		RETester.eq(getMoves(new String[] {
			"XXX..XXX..XXX.",
			".X..X....X...X",
			".X..X....X...X",
			".X..X....X...X",
			".X...XXX..XXX.",
			"..............",
			"...XX...XXX...",
			"....X......X..",
			"....X....XXX..",
			"....X......X..",
			"...XXX..XXX..."},
			1, 2), 7);
	}

// END CUT HERE
}
