package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1724 (10783 - Odd Sum) */
/* SUBMISSION: 08796304 */
/* SUBMISSION TIME: 2011-04-30 14:28:51 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10783_OddSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = 0;

            for (int i = a; i <= b; ++i)
                if (i % 2 == 1) sum += i;
            System.out.println("Case " + t + ": " + sum);
        }
    }
}
