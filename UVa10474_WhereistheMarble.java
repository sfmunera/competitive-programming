package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1415 (10474 - Where is the Marble?) */
/* SUBMISSION: 08518325 */
/* SUBMISSION TIME: 2011-01-18 18:45:57 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10474_WhereistheMarble {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int caso = 1;
            while (true) {
                int n = in.nextInt();
                int q = in.nextInt();

                if (n == 0 && q == 0) break;

                int[] marbles = new int[n];
                int[] queries = new int[q];
                for (int i = 0; i < n; ++i)
                    marbles[i] = in.nextInt();
                for (int i = 0; i < q; ++i)
                    queries[i] = in.nextInt();

                Arrays.sort(marbles);
                System.out.println("CASE# " + caso + ":");

                for (int i = 0; i < q; ++i) {
                    int pos = -1;
                    for (int j = 0; j < marbles.length; ++j) {
                        if (marbles[j] == queries[i]) {
                            pos = j;
                            break;
                        }
                    }
                    if (pos >= 0) System.out.println(queries[i] + " found at " + (pos + 1));
                    else System.out.println(queries[i] + " not found");
                }
                ++caso;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}