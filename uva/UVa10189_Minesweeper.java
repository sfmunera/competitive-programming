package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1130 (10189 - Minesweeper) */
/* SUBMISSION: 08793162 */
/* SUBMISSION TIME: 2011-04-29 16:37:36 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10189_Minesweeper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 1;
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) break;
            char[][] field = new char[n][m];

            for (int i = 0; i < n; ++i)
                field[i] = in.next().toCharArray();

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    if (field[i][j] == '.') {
                        int mines = 0;
                        if (i > 0 && j > 0 && field[i - 1][j - 1] == '*') ++mines;
                        if (j > 0 && field[i][j - 1] == '*') ++mines;
                        if (i < n - 1 && j > 0 && field[i + 1][j - 1] == '*') ++mines;
                        if (i > 0 && field[i - 1][j] == '*') ++mines;
                        if (i < n - 1 && field[i + 1][j] == '*') ++mines;
                        if (i > 0 && j < m - 1 && field[i - 1][j + 1] == '*') ++mines;
                        if (j < m - 1 && field[i][j + 1] == '*') ++mines;
                        if (i < n - 1 && j < m - 1 && field[i + 1][j + 1] == '*') ++mines;
                        field[i][j] = (char)(mines + '0');
                    }
            if (cnt > 1) System.out.println();
            System.out.println("Field #" + cnt + ":");
            for (int i = 0; i < n; ++i)
                System.out.println(String.valueOf(field[i]));
            ++cnt;
        }
    }
}
