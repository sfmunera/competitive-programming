package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 429 (488 - Triangle Wave) */
/* SUBMISSION: 08813412 */
/* SUBMISSION TIME: 2011-05-05 13:42:26 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00488_TriangleWave {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] amplitudes = {"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "999999999"};
        int T = in.nextInt();

        while (T-- > 0) {
            int A = in.nextInt();
            int F = in.nextInt();
            StringBuilder wave = new StringBuilder();

            int k = 1;
            int d = 1;
            while (k > 0) {
                wave.append(amplitudes[k - 1]);
                wave.append("\n");
                if (k == A) d = -1;
                k += d;
            }

            for (int i = 0; i < F; ++i) {
                System.out.print(wave);
                if (i < F - 1) System.out.println();
            }
            if (T > 0) System.out.println();
        }
    }
}
