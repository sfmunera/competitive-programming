package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1644 (10703 - Free spots) */
/* SUBMISSION: 08789379 */
/* SUBMISSION TIME: 2011-04-28 16:06:27 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10703_Freespots {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int W = in.nextInt();
            int H = in.nextInt();
            int N = in.nextInt();
            if (W == 0 && H == 0 && N == 0) break;
            boolean[][] board = new boolean[H][W];

            for (int i = 0; i < N; ++i) {
                int X1 = in.nextInt();
                int Y1 = in.nextInt();
                int X2 = in.nextInt();
                int Y2 = in.nextInt();

                for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); ++x)
                    for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); ++y)
                        board[y - 1][x - 1] = true;
            }

            int res = 0;
            for (int i = 0; i < H; ++i)
                for (int j = 0; j < W; ++j)
                    if (!board[i][j]) ++res;
            if (res == 0)
                System.out.println("There is no empty spots.");
            else if (res == 1)
                System.out.println("There is one empty spot.");
            else
                System.out.println("There are " + res + " empty spots.");
        }
    }
}
