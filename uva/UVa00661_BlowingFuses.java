package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 602 (661 - Blowing Fuses) */
/* SUBMISSION: 08790089 */
/* SUBMISSION TIME: 2011-04-28 19:35:39 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00661_BlowingFuses {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int seq = 1;
            while (true) {
                int n = in.nextInt();
                int m = in.nextInt();
                int c = in.nextInt();
                if (n == 0 && m == 0 && c == 0)
                    break;

                //if (seq > 1) System.out.println();
                long[] cap = new long[n];
                boolean[] on = new boolean[n];

                for (int i = 0; i < n; ++i)
                    cap[i] = in.nextLong();

                System.out.println("Sequence " + seq);
                long max = 0;
                boolean blown = false;

                for (int i = 0; i < m; ++i) {
                    int k = in.nextInt();
                    on[k - 1] = !on[k - 1];

                    long sum = 0;
                    for (int j = 0; j < n; ++j)
                        if (on[j]) sum += cap[j];
                    
                    if (sum > c)
                        blown = true;
                    else
                        max = Math.max(max, sum);
                    
                }

                if (!blown) {
                    System.out.println("Fuse was not blown.");
                    System.out.println("Maximal power consumption was " + max + " amperes.");
                } else
                    System.out.println("Fuse was blown.");
                ++seq;
                System.out.println();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}