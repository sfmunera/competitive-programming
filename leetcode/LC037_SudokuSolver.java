package leetcode;

public class LC037_SudokuSolver {
    public void solveSudoku(char[][] board) {
        int side = board.length;
        int[] seenRow = new int[side];
        int[] seenCol = new int[side];
        int[][] seenSquare = new int[side/3][side/3];
        
        for (int i = 0; i < side; ++i)
            for (int j = 0; j < side; ++j)
                if (board[i][j] != '.') {
                    int d = board[i][j] - '0';
                    seenRow[i] = setBit(seenRow[i], d);
                    seenCol[j] = setBit(seenCol[j], d);
                    seenSquare[i/3][j/3] = setBit(seenSquare[i/3][j/3], d);
                }
        
        solveSudokuHelper(board, 0, 0, seenRow, seenCol, seenSquare);
    }
    
    boolean isClear(int x, int d) {
        return (x & (1 << d)) == 0;
    }
    
    int setBit(int x, int d) {
        return x | (1 << d);
    }
    
    int clearBit(int x, int d) {
        return x & (~(1 << d));
    }
    
    public boolean solveSudokuHelper(char[][] board, int r, int c, int[] seenRow, int[] seenCol, int[][] seenSquare) {
        int side = board.length;
        if (r >= side)
            return true;
        
        if (board[r][c] != '.') {
            return solveSudokuHelper(board, c == side - 1 ? r + 1 : r, (c + 1) % side, seenRow, seenCol, seenSquare);
        } else {
            for (int d = 1; d <= side; ++d) {
                if (isClear(seenRow[r], d) && isClear(seenCol[c], d) && isClear(seenSquare[r / 3][c / 3], d)) {
                    board[r][c] = (char) (d + '0');
                    seenRow[r] = setBit(seenRow[r], d);
                    seenCol[c] = setBit(seenCol[c], d);
                    seenSquare[r/3][c/3] = setBit(seenSquare[r/3][c/3], d);
                    if (solveSudokuHelper(board, c == side - 1 ? r + 1 : r, (c + 1) % side, seenRow, seenCol, seenSquare)) {
                        return true;
                    }
                    board[r][c] = '.';
                    seenRow[r] = clearBit(seenRow[r], d);
                    seenCol[c] = clearBit(seenCol[c], d);
                    seenSquare[r/3][c/3] = clearBit(seenSquare[r/3][c/3], d);
                }
            }
        }
        return false;
    }
}
