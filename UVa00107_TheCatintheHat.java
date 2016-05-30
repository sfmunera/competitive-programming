package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 43 (107 - The Cat in the Hat) */
/* SUBMISSION: 08752897 */
/* SUBMISSION TIME: 2011-04-17 00:43:58 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00107_TheCatintheHat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double EPS = 1e-6;
        while (true) {
            int H = in.nextInt();
            int nworkers = in.nextInt();
            if (H == 0 && nworkers == 0) break;
            int h = 1;
            int N = 1;
            long noworkers = 0;
            long totalh = 0;

            if (H == 1 && nworkers == 1) {
                noworkers = 0;
                totalh = 1;
            } else {
                for (int q = 1; q <= 64; ++q) {
                    double pow1 = Math.pow(nworkers, 1.0 / q);
                    double pow2 = Math.pow(H, 1.0 / q) - 1;
                    if (Math.abs(pow1 - pow2) < EPS) {
                        N = (int)Math.round(pow1);
                        h = q;
                        break;
                    }
                }
                //System.out.println(N + " " + h);
                long[] powN = new long[h + 1];
                long[] powN1 = new long[h + 1];
                powN[0] = 1;
                powN1[0] = 1;
                for (int i = 1; i < h + 1; ++i) {
                    powN[i] = powN[i - 1] * N;
                    powN1[i] = powN1[i - 1] * (N + 1);
                }
                for (int i = 0; i < h; ++i)
                    noworkers += powN[i];
                for (int i = 0; i < h + 1; ++i)
                    totalh += powN[i] * powN1[h - i];
            }
            System.out.println(noworkers + " " + totalh);
        }
    }
}
