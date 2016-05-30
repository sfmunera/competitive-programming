package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1753 (10812 - Beat the Spread!) */
/* SUBMISSION: 08789403 */
/* SUBMISSION TIME: 2011-04-28 16:14:20 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10812_BeattheSpread {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            int s = in.nextInt();
            int d = in.nextInt();

            int a = (s + d) / 2;
            int b = s - a;

            if (a >= 0 && b >= 0 && a - b == d)
                System.out.println(a + " " + b);
            else
                System.out.println("impossible");
        }
    }
}
