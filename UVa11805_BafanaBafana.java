package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2905 (11805 - Bafana Bafana) */
/* SUBMISSION: 08634170 */
/* SUBMISSION TIME: 2011-03-08 23:55:55 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11805_BafanaBafana {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int K = in.nextInt();
            int P = in.nextInt();

            System.out.println("Case " + t + ": " + ((K - 1 + P) % N + 1));
        }
    }
}
