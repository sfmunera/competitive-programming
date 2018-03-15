package codeforces;

import java.util.*;

public class DZYLovesChessboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = in.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = (i + j) % 2 == 0 ? 'B' : 'W';
                }
            }
            System.out.println(board[i]);
        }
        
        in.close();
        System.exit(0);
    }
}
