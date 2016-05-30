import java.util.*;
import java.io.*;

public class Minesweeper {
	public static final boolean LINUX_TERM = true;
	
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static String[] colors = {ANSI_WHITE, ANSI_CYAN, ANSI_GREEN, ANSI_RED, ANSI_BLUE, ANSI_PURPLE};
	
	public static final int ROWS = 16;
	public static final int COLS = 30;
	public static final int NUM_MINES = 99;
	public static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static class Cell {
		private boolean isVisible;
		private boolean hasFlag;
		private int value;
		public Cell(int v) {
			value = v;
			isVisible = false;
			hasFlag = false;
		}
		public boolean isVisible() {
			return isVisible;
		}
		public boolean hasFlag() {
			return hasFlag;
		}
		public void setVisible(boolean vis) {
			isVisible = vis;
		}
		public void toggleFlag() {
			hasFlag = !hasFlag;
		}
		public boolean isMine() {
			return value == -1;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int v) {
			value = v;
		}
		public String getColor() {
			if (!LINUX_TERM) return "";
			if (!this.isVisible()) return ANSI_YELLOW;
			if (this.hasFlag() || this.isMine()) return ANSI_RED;
			return colors[this.getValue() % colors.length];
		}
		public Character getChar() {
			if (!this.isVisible()) return '?';
			if (this.hasFlag()) return 'F';
			if (this.isMine()) return '*';
			return (char) (this.getValue() + '0');
		}
	}
	
	static Cell[][] field;
	
	static boolean inside(int i, int j) {
		return i >= 0 && j >= 0 && i < ROWS && j < COLS;
	}
	
	static void initialize() {
		// Put mines
		Random r = new Random();
		for (int i = 0; i < NUM_MINES; ++i)
			while (true) {
				int row = r.nextInt(ROWS);
				int col = r.nextInt(COLS);
				if (!field[row][col].isMine() && !field[row][col].isVisible()) {
					field[row][col].setValue(-1);
					break;
				}
			}
		// Count neighboring mines
		for (int i = 0; i < ROWS; ++i)
			for (int j = 0; j < COLS; ++j)
				if (!field[i][j].isMine()) {
					int cnt = 0;
					for (int d = 0; d < 8; ++d) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						if (inside(ni, nj) && field[ni][nj].isMine())
							++cnt;
					}
					field[i][j].setValue(cnt);
				}
	}
	
	static boolean hasWon() {
		for (int i = 0; i < ROWS; ++i)
			for (int j = 0; j < COLS; ++j)
				if (!field[i][j].isMine() && !field[i][j].isVisible)
					return false;
		return true;
	}
	
	static void updateField(int row, int col) {
		field[row][col].setVisible(true);
		
		if (field[row][col].getValue() == 0)
			for (int d = 0; d < 8; ++d) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (inside(nr, nc) && !field[nr][nc].isVisible() && !field[nr][nc].isMine())
					updateField(nr, nc);
			}
	}
	
	static void clearConsole() {
		if (LINUX_TERM) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
	}

	static void setNormalColor() {
		if (LINUX_TERM)
			System.out.print(ANSI_WHITE);
	}

	static void printField(boolean ended) {
		int numFlags = 0;
		clearConsole();
		setNormalColor();
		System.out.print("\n   " + 0);
		for (int i = 1; i < COLS; ++i)
			System.out.print(" " + (i < 10 ? " " : "") + i);
		System.out.println();
		
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				setNormalColor();
				if (j == 0) System.out.print((i < 10 ? " " : "") + i + " ");
				else System.out.print("  ");
				
				if (ended && field[i][j].isMine()) field[i][j].setVisible(true);
				System.out.print(field[i][j].getColor() + field[i][j].getChar());
				
				if (field[i][j].hasFlag()) ++numFlags;
			}
			System.out.println();
		}
		setNormalColor();
		System.out.println("\nRemaining mines: " + (NUM_MINES - numFlags));
	}
	
	public static void main(String[] args) throws IOException {
		field = new Cell[ROWS][COLS];
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < ROWS; ++i)
			for (int j = 0; j < COLS; ++j)
				field[i][j] = new Cell(0);

		boolean first = true;
		while (true) {
			printField(false);
			System.out.println("\nWhich one? (in the form \"[M|F] row col\")");
			
			String line = in.nextLine();
			String[] parts = line.split("[ ]+");
			
			int row = 0, col = 0;
			if (parts.length != 3) continue;
			if (parts[0].length() != 1) continue;
			
			char command = parts[0].charAt(0);
			if (command != 'M' && command != 'm' && command != 'F' && command != 'f')
				continue;
			try {
				row = Integer.parseInt(parts[1]);
				col = Integer.parseInt(parts[2]);
			} catch (Exception e) {
				continue;
			}
			if (!inside(row, col)) continue;
			
			if (command == 'M' || command == 'm') {
				if (field[row][col].hasFlag()) continue;
				field[row][col].setVisible(true);
				if (first) {
					first = false;
					initialize();
				}
				if (field[row][col].isMine()) {
					printField(true);
					System.out.println("YOU LOST!!");
					break;
				} else if (hasWon()) {
					printField(true);
					System.out.println("YOU WON!!");
					break;
				} else
					updateField(row, col);
			} else if (!field[row][col].isVisible)
					field[row][col].toggleFlag();
		}
		
		in.close();
		System.exit(0);
	}
}
