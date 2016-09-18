package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1304 (10363 - Tic Tac Toe) */
/* SUBMISSION: 08790156 */
/* SUBMISSION TIME: 2011-04-28 19:54:59 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10363_TicTacToe {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int N = Integer.parseInt(in.nextLine());

            for (int i = 0; i < N; ++i) {
                if (i > 0) in.nextLine();
                char[][] game = new char[3][3];
                int nX = 0;
                int nO = 0;
                for (int j = 0; j < 3; ++j)
                    game[j] = in.nextLine().toCharArray();
                for (int j = 0; j < 3; ++j)
                    for (int k = 0; k < 3; ++k) {
                        if (game[j][k] == 'X') ++nX;
                        if (game[j][k] == 'O') ++nO;
                    }
                if (nO > nX || nX > nO + 1)
                    System.out.println("no");
                else if (nX == nO) {
                    boolean valid = true;
                    if (game[0][0] == 'X' && game[0][1] == 'X' && game[0][2] == 'X') valid = false;
                    if (game[1][0] == 'X' && game[1][1] == 'X' && game[1][2] == 'X') valid = false;
                    if (game[2][0] == 'X' && game[2][1] == 'X' && game[2][2] == 'X') valid = false;
                    if (game[0][0] == 'X' && game[1][0] == 'X' && game[2][0] == 'X') valid = false;
                    if (game[0][1] == 'X' && game[1][1] == 'X' && game[2][1] == 'X') valid = false;
                    if (game[0][2] == 'X' && game[1][2] == 'X' && game[2][2] == 'X') valid = false;
                    if (game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X') valid = false;
                    if (game[2][0] == 'X' && game[1][1] == 'X' && game[0][2] == 'X') valid = false;
                    System.out.println(valid ? "yes" : "no");
                } else if (nX == nO + 1) {
                    boolean valid = true;
                    if (game[0][0] == 'O' && game[0][1] == 'O' && game[0][2] == 'O') valid = false;
                    if (game[1][0] == 'O' && game[1][1] == 'O' && game[1][2] == 'O') valid = false;
                    if (game[2][0] == 'O' && game[2][1] == 'O' && game[2][2] == 'O') valid = false;
                    if (game[0][0] == 'O' && game[1][0] == 'O' && game[2][0] == 'O') valid = false;
                    if (game[0][1] == 'O' && game[1][1] == 'O' && game[2][1] == 'O') valid = false;
                    if (game[0][2] == 'O' && game[1][2] == 'O' && game[2][2] == 'O') valid = false;
                    if (game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O') valid = false;
                    if (game[2][0] == 'O' && game[1][1] == 'O' && game[0][2] == 'O') valid = false;
                    System.out.println(valid ? "yes" : "no");
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}