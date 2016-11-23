public class ChessMissingOppositeCorners {
	
	static final int SIZE = 8;
	
	static Integer[][][][] dp;
	
	static boolean hasTile(int rowMask, int col) {
		return (rowMask & (1 << col)) > 0;
	}
	
	static int putTile(int rowMask, int col) {
		return rowMask | (1 << col);
	}
	
	static int countWays(int rowMask, int nextMask, int row, int col) {
		if (col == SIZE) {
			row++;
			col = 0;
			rowMask = nextMask;
			nextMask = row == SIZE - 2 ? (1 << (SIZE - 1)) : 0;
		}
		if (row == SIZE - 1 && col == SIZE - 1) {
			return hasTile(rowMask, col) ? 1 : 0;
		}
		if (row == SIZE) {
			return 0;
		}
		
		if (dp[rowMask][nextMask][row][col] != null) {
			return dp[rowMask][nextMask][row][col];
		}
		
		int ways = 0;
		
		if (hasTile(rowMask, col)) {
			ways += countWays(rowMask, nextMask, row, col + 1);
		} else {
			//put tile horizontally
			if (col < SIZE - 1 && !hasTile(rowMask, col) && !hasTile(rowMask, col + 1)) {
				ways += countWays(putTile(putTile(rowMask, col), col + 1), nextMask, row, col + 1);
			}
			
			//put tile vertically
			if (row < SIZE - 1 && !hasTile(rowMask, col) && !hasTile(nextMask, col)) {
				ways += countWays(putTile(rowMask, col), putTile(nextMask, col), row, col + 1);
			}
		}

		return dp[rowMask][nextMask][row][col] = ways;
	}
	
	public static void main(String[] args) {
		dp = new Integer[(1 << SIZE) + 1][(1 << SIZE) + 1][SIZE + 1][SIZE + 1];
		System.out.println(countWays(1 << 0, 0, 0, 0));
	}
}
