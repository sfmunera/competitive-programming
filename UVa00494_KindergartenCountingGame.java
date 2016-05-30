package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 435 (494 - Kindergarten Counting Game) */
/* SUBMISSION: 08634189 */
/* SUBMISSION TIME: 2011-03-09 00:06:01 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00494_KindergartenCountingGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            int cnt = 0;
            int i = 0;
            while (i < line.length()) {
                if (Character.isLetter(line.charAt(i))) {
                    ++cnt;
                    while (Character.isLetter(line.charAt(i))) ++i;
                }
                ++i;
            }
            System.out.println(cnt);
        }
    }
}
