package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1023 (10082 - WERTYU) */
/* SUBMISSION: 08574062 */
/* SUBMISSION TIME: 2011-02-12 21:07:27 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10082_WERTYU {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            char[][] keyboard =
            {
                {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
                {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'},
                {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', ' ', ' '},
                {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/', ' ', ' ', ' '}
            };

            while (in.hasNextLine()) {
                String line = in.nextLine();
                for (int i = 0; i < line.length(); ++i) {
                    char ch = line.charAt(i);
                    if (ch != ' ') {
                        for (int r = 0; r < 4; ++r)
                            for (int c = 1; c < 13; ++c)
                                if (keyboard[r][c] == ch) {
                                    ch = keyboard[r][c - 1];
                                    break;
                                }
                    }
                    System.out.print(ch);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}