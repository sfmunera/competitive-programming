package livearchive;

import java.util.*;
import java.io.*;

public class FunHouse {
	
	static int[] dr = {0, 1,  0, -1};
	static int[] dc = {1, 0, -1,  0};
	
	static class Pair { int r, c; Pair(int r, int c) { this.r = r; this.c = c; }}
	
	static Pair findStart(char[][] room) {
		for (int i = 0; i < room.length; ++i) {
			for (int j = 0; j < room[0].length; ++j) {
				if (room[i][j] == '*') {
					return new Pair(i, j);
				}
			}
		}
		
		return new Pair(-1, -1);
	}
	
	static int findDir(Pair start, int R, int C) {
		if (start.c == 0) return 0; // E
		if (start.r == 0) return 1; // S
		if (start.c == C - 1) return 2; // W
		if (start.r == R - 1) return 3; // N
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			int C = in.nextInt();
			int R = in.nextInt();
			
			if (R == 0 && C == 0) {
				break;
			}
			
			char[][] room = new char[R][C];
			for (int i = 0; i < R; ++i) {
				room[i] = in.next().toCharArray();
			}
			
			Pair cur = findStart(room);
			int dir = findDir(cur, R, C); // ESWN
			
			while (true) {
				if (room[cur.r][cur.c] == 'x') {
					room[cur.r][cur.c] = '&';
					break;
				}
				if (room[cur.r][cur.c] == '\\') {
					if (dir == 0) { // E
						dir = 1;
					} else if (dir == 1) { // S
						dir = 0;
					} else if (dir == 2) { // W
						dir = 3;
					} else { // N
						dir = 2;
					}
				} else if (room[cur.r][cur.c] == '/') {
					if (dir == 0) { // E
						dir = 3;
					} else if (dir == 1) { // S
						dir = 2;
					} else if (dir == 2) { // W
						dir = 1;
					} else { // N
						dir = 0;
					}
				}
				cur.r += dr[dir];
				cur.c += dc[dir];
			}
			
			System.out.println("HOUSE " + t);
			for (int i = 0; i < R; ++i) {
				System.out.println(room[i]);
			}
			
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
