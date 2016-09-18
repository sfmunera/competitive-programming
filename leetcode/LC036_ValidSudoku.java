package leetcode;

public class LC036_ValidSudoku {
    
    boolean isDigit(char c) {
        return c >= '1' && c <= '9';
    }
    
    boolean isColumnValid(char[][] board, int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 9; ++i) {
            if (!isDigit(board[i][col])) continue;
            if (seen[board[i][col] - '0']) return false;
            seen[board[i][col] - '0'] = true;
        }
        
        return true;
    }
    
    boolean isRowValid(char[][] board, int row) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 9; ++i) {
            if (!isDigit(board[row][i])) continue;
            if (seen[board[row][i] - '0']) return false;
            seen[board[row][i] - '0'] = true;
        }
        
        return true;
    }
    
    boolean isSquareValid(char[][] board, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!isDigit(board[row + i][col + j])) continue;
            if (seen[board[row + i][col + j] - '0']) return false;
            seen[board[row + i][col + j] - '0'] = true;
            }
            
        }
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        for (int col = 0; col < 9; ++col) {
            if (!isColumnValid(board, col))
                return false;
        }
        
        for (int row = 0; row < 9; ++row) {
            if (!isRowValid(board, row)) 
                return false;
        }
        
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isSquareValid(board, row, col))
                    return false;
            }
        }
        
        return true;
    }
}