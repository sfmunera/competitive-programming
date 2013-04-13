package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2288 (11313 - Gourmet Games) */
/* SUBMISSION: 08790587 */
/* SUBMISSION TIME: 2011-04-29 00:37:57 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11313_GourmetGames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            int cnt = 0;
            while (n > 1) {
                n = n - m + 1;
                ++cnt;
            }
            if (n == 1)
                System.out.println(cnt);
            else
                System.out.println("cannot do this");
        }
    }
}
