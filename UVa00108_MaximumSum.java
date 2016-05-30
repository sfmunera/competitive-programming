package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 44 (108 - Maximum Sum) */
/* SUBMISSION: 08752965 */
/* SUBMISSION TIME: 2011-04-17 01:38:10 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00108_MaximumSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[][] mat = new int[N][N];

            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    mat[i][j] = in.nextInt();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    int[] sumc = new int[N - j];
                    int[] sumr = new int[N - j];
                    for (int m = i; m < N; ++m) {
                        for (int n = j; n < N; ++n) {
                            sumc[n - j] = (n - j - 1 >= 0 ? sumc[n - j - 1] : 0) + mat[m][n];
                            sumr[n - j] += sumc[n - j];
                            max = Math.max(max, sumr[n - j]);
                        }
                    }
                }
            }
            System.out.println(max);

        }
    }
}
