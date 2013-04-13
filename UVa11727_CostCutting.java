package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2827 (11727 - Cost Cutting) */
/* SUBMISSION: 08790000 */
/* SUBMISSION TIME: 2011-04-28 19:06:06 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11727_CostCutting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int[] n = new int[3];
            n[0] = in.nextInt();
            n[1] = in.nextInt();
            n[2] = in.nextInt();
            Arrays.sort(n);
            System.out.println("Case " + t + ": " + n[1]);
        }
    }
}
