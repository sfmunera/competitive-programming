package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2383 (11388 - GCD LCM) */
/* SUBMISSION: 08790743 */
/* SUBMISSION TIME: 2011-04-29 02:38:37 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11388_GCDLCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int G = in.nextInt();
            int L = in.nextInt();

            if (G > L || L % G != 0)
                System.out.println(-1);
            else
                System.out.println(G + " " + L);
        }
    }
}
