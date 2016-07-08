package leetcode;

import java.util.*;

public class LC051_NQueens {
    public List<String[]> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(board[i], '.');
            
        int[] seenRow = new int[n];
        Arrays.fill(seenRow, -1);
        return solveNQueensHelper(n, 0, seenRow, board);
    }
    
    public List<String[]> solveNQueensHelper(int n, int col, int[] seenRow, char[][] board) {
        List<String[]> solutions = new ArrayList<String[]>();
        
        if (col == n) {
            String[] sol = new String[n];
            for (int i = 0; i < n; ++i)
                sol[i] = String.valueOf(board[i]);
            
            solutions.add(sol);
            return solutions;
        }
        
        for (int row = 0; row < n; ++row) {
            if (seenRow[row] != -1)
                continue;
            boolean valid = true;
            for (int i = 0; i < n; ++i) {
                if (seenRow[i] != -1 && Math.abs(row - i) == Math.abs(col - seenRow[i])) {
                    valid = false;
                    break;
                }
            }
            
            if (!valid)
                continue;
            
            seenRow[row] = col;
            board[row][col] = 'Q';
            solutions.addAll(solveNQueensHelper(n, col + 1, seenRow, board));
            seenRow[row] = -1;
            board[row][col] = '.';
        }
        
        return solutions;
    }
}
