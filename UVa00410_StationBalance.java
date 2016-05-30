package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 351 (410 - Station Balance) */
/* SUBMISSION: 08912828 */
/* SUBMISSION TIME: 2011-06-02 14:02:26 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00410_StationBalance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        while (in.hasNextInt()) {
            ++cnt;
            int C = in.nextInt();
            int S = in.nextInt();
            double AM = 0.0;
            double imbalance = 0.0;
            int[] sorted = new int[2 * C];
            
            for (int i = 0; i < S; ++i) {
                sorted[i] = in.nextInt();
                AM += sorted[i];
            }
            Arrays.sort(sorted);            
            AM /= C;
            
            System.out.println("Set #" + cnt);
            int k = 0;
            for (int i = 2 * C - 1; i >= C; --i) {
            	System.out.println(" " + k + ":" + (sorted[i] != 0 ? " " + sorted[i] : "") + 
            			(sorted[2 * C - 1 -i] != 0 ? " " + sorted[2 * C - 1 - i] : ""));
            	double mass = sorted[i] + sorted[2 * C - 1 - i];
            	imbalance += Math.abs(mass - AM);
            	++k;
            }

            System.out.printf(Locale.ENGLISH, "IMBALANCE = %.5f%n%n", imbalance);
        }
    }
}
