package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 386 (445 - Marvelous Mazes) */
/* SUBMISSION: 08634203 */
/* SUBMISSION TIME: 2011-03-09 00:15:05 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00445_MarvelousMazes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String maze = in.nextLine();
            if (maze.isEmpty()) {
                System.out.println();
                continue;
            }

            int cnt = 0;
            for (int i = 0; i < maze.length(); ++i) {
                char c = maze.charAt(i);
                if (Character.isDigit(c)) cnt += c - '0';
                if (c == 'b') c = ' ';
                if(Character.isLetter(c) || c == ' ' || c == '*') {
                    for (int j = 0; j < cnt; ++j)
                        System.out.print(c);
                    cnt = 0;
                }
                if (c == '!') System.out.println();
            }
            System.out.println();
        }
    }
}
