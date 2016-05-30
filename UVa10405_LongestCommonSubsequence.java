package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1346 (10405 - Longest Common Subsequence) */
/* SUBMISSION: 08510527 */
/* SUBMISSION TIME: 2011-01-15 02:08:09 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10405_LongestCommonSubsequence {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextLine()) {
                char[] x = in.nextLine().toCharArray();
                char[] y = in.nextLine().toCharArray();
                int n = x.length;
                int m = y.length;

                int[][] C = new int[n + 1][m + 1];

                for (int i = 1; i <= n; ++i) {
                    for (int j = 1; j <= m; ++j) {
                        if (x[i - 1] == y[j - 1])
                            C[i][j] = C[i - 1][j - 1] + 1;
                        else
                            C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
                    }
                }
                System.out.println(C[n][m]);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}