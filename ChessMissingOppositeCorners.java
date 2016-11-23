public class ChessMissingOppositeCorners {
	
	static final int SIZE = 8;
	static final int FIRST_ROW_MASK = 1 << 0;         // #.......
	static final int LAST_ROW_MASK = 1 << (SIZE - 1); // .......#
	static final int EMPTY_ROW_MASK = 0;              // ........
	
	static Integer[][][][] dp;
	
	static boolean isFree(int rowMask, int col) {
		return (rowMask & (1 << col)) == 0;
	}
	
	static int putTile(int rowMask, int col) {
		return rowMask | (1 << col);
	}
	
	static int countWays(int rowMask, int nextMask, int row, int col) {
		if (col == SIZE) {
			row++;
			col = 0;
			rowMask = nextMask;
			nextMask = row == SIZE - 2 ? LAST_ROW_MASK : EMPTY_ROW_MASK;
		}
		if (row == SIZE - 1 && col == SIZE - 1) {
			return isFree(rowMask, col) ? 0 : 1;
		}
		if (row == SIZE) {
			return 0;
		}
		
		if (dp[rowMask][nextMask][row][col] != null) {
			return dp[rowMask][nextMask][row][col];
		}
		
		int ways = 0;
		
		if (!isFree(rowMask, col)) {
			ways += countWays(rowMask, nextMask, row, col + 1);
		} else {
			//put tile horizontally
			if (col < SIZE - 1 && isFree(rowMask, col) && isFree(rowMask, col + 1)) {
				ways += countWays(putTile(putTile(rowMask, col), col + 1), nextMask, row, col + 1);
			}
			
			//put tile vertically
			if (row < SIZE - 1 && isFree(rowMask, col) && isFree(nextMask, col)) {
				ways += countWays(putTile(rowMask, col), putTile(nextMask, col), row, col + 1);
			}
		}

		return dp[rowMask][nextMask][row][col] = ways;
	}
	
	public static void main(String[] args) {
		dp = new Integer[(1 << SIZE) + 1][(1 << SIZE) + 1][SIZE + 1][SIZE + 1];
		System.out.println(countWays(FIRST_ROW_MASK, EMPTY_ROW_MASK, 0, 0));
	}
}
