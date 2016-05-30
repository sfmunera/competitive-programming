package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 310 (374 - Big Mod) */
/* SUBMISSION: 08813505 */
/* SUBMISSION TIME: 2011-05-05 14:13:06 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00374_BigMod {

    static int fastPow(int B, int P, int M) {
        if (P == 0) return 1;
        if (P == 1) return B;
        if ((P & 1) == 1)
            return ((B % M) * fastPow(((B % M) * (B % M)) % M, (P - 1) / 2, M) % M) % M;
        else
            return fastPow(((B % M) * (B % M)) % M, P / 2, M);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int B = in.nextInt();
            int P = in.nextInt();
            int M = in.nextInt();

            int res = fastPow(B, P, M);
            System.out.println(res);
        }
    }
}
