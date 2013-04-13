package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1311 (10370 - Above Average) */
/* SUBMISSION: 08796237 */
/* SUBMISSION TIME: 2011-04-30 14:09:50 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10370_AboveAverage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int C = in.nextInt();
        while (C-- > 0) {
            int N = in.nextInt();
            int[] est = new int[N];
            double avg = 0.0;
            for (int i = 0; i < N; ++i) {
                est[i] = in.nextInt();
                avg += est[i];
            }
            avg /= N;
            int cnt = 0;
            for (int i = 0; i < N; ++i)
                if (est[i] > avg)
                    ++cnt;
            System.out.printf(Locale.ENGLISH, "%.3f", 100.0 * cnt / N);
            System.out.println("%");
        }
    }
}
