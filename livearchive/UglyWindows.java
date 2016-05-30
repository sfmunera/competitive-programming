package livearchive;

import java.util.*;

public class UglyWindows {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Pair {
		int r, c;
		Pair(int r, int c) { this.r = r; this.c = c; }
	}
	
	static Pair getInitialPosition(char[][] screen, char id) {
		for (int i = 0; i < screen.length; ++i) {
			for (int j = 0; j < screen[0].length; ++j) {
				if (screen[i][j] == id) {
					return new Pair(i, j);
				}
			}
		}
		return new Pair(-1, -1);
	}
	
	static Pair getLastPosition(char[][] screen, char id) {
		for (int i = screen.length - 1; i >= 0; --i) {
			for (int j = screen[0].length - 1; j >= 0; --j) {
				if (screen[i][j] == id) {
					return new Pair(i, j);
				}
			}
		}
		return new Pair(-1, -1);
	}
	
	static boolean inside(int r, int c, int rows, int cols) {
		return r >= 0 && c >= 0 && r < rows && c < cols;
	}
	
	static boolean isFullFrame(char[][] screen, char id) {
		int rows = screen.length;
		int cols = screen[0].length;
		Pair pos = getInitialPosition(screen, id);
		
		if (pos.r == -1 && pos.c == -1) {
			return false;
		}
		
		int r = pos.r;
		int c = pos.c;
		int dir = 0;
		while (true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (!inside(nr, nc, rows, cols) || screen[nr][nc] != id) {
				dir = (dir + 1) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (!inside(nr, nc, rows, cols) || screen[nr][nc] != id) {
					break;
				}
			}
			
			if (nr == pos.r && nc == pos.c) {
				return true;
			}
			
			r = nr;
			c = nc;
		}
		
		return false;
	}
	
	static boolean isEmptyRectangle(char[][] screen, char id) {
		Pair first = getInitialPosition(screen, id);
		Pair last = getLastPosition(screen, id);
		
		for (int i = first.r + 1; i < last.r; ++i) {
			for (int j = first.c + 1; j < last.c; ++j) {
				if (screen[i][j] != '.') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean isOnTop(char[][] screen, char id) {
		return isFullFrame(screen, id) && isEmptyRectangle(screen, id);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int rows = in.nextInt();
			int cols = in.nextInt();
			
			if (rows == 0 && cols == 0) {
				break;
			}
			
			char[][] screen = new char[rows][cols];
			for (int i = 0; i < rows; ++i) {
				screen[i] = in.next().toCharArray();
				for (int j = 0; j < cols; ++j) {
					if (screen[i][j] < 'A' || screen[i][j] > 'Z') {
						screen[i][j] = '.';
					}
				}
			}
			
			String ans = "";
			for (char id = 'A'; id <= 'Z'; ++id) {
				if (isOnTop(screen, id)) {
					ans += id;
				}
			}
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
