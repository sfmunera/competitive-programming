package leetcode;

public class LC529_Minesweeper {
    private int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    private boolean inside(int row, int col, int rows, int cols) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
    
    private boolean isRevealed(char c) {
        return c != 'E' && c != 'M';
    }
    
    private int countAdjacentMines(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;
        for (int d = 0; d < dr.length; d++) {
            int nRow = row + dr[d];
            int nCol = col + dc[d];
            if (inside(nRow, nCol, rows, cols) && board[nRow][nCol] == 'M') {
                count++;
            }
        }
        return count;
    }
    
    private void reveal(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int count = countAdjacentMines(board, row, col);
        if (count == 0) {
            board[row][col] = 'B';
            for (int d = 0; d < dr.length; d++) {
                int nRow = row + dr[d];
                int nCol = col + dc[d];
                if (inside(nRow, nCol, rows, cols) && !isRevealed(board[nRow][nCol])) {
                    reveal(board, nRow, nCol);
                }
            }
        } else {
            board[row][col] = (char)(count + '0');
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            reveal(board, row, col);
        }
        return board;
    }
}
