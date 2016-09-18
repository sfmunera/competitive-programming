package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 355 (414 - Machined Surfaces) */
/* SUBMISSION: 08510193 */
/* SUBMISSION TIME: 2011-01-14 19:53:14 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00414_MachinedSurfaces {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (true) {
                int n = Integer.parseInt(in.nextLine());

                if (n == 0) break;
                int[] voids = new int[n];
                int min = Integer.MAX_VALUE;
                int res = 0;

                for (int i = 0; i < n; ++i) {
                    String row = in.nextLine();
                    for (int j = 0; j < row.length(); ++j)
                        if (row.charAt(j) == ' ') ++voids[i];
                }

                for (int i = 0; i < n; ++i)
                    min = Math.min(min, voids[i]);

                for (int i = 0; i < n; ++i)
                    res += voids[i] - min;

                System.out.println(res);

            }

        } catch (Exception e) {
            System.exit(0);
        }
    }
}
