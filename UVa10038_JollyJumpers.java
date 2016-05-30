package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 979 (10038 - Jolly Jumpers) */
/* SUBMISSION: 08792863 */
/* SUBMISSION TIME: 2011-04-29 15:32:20 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10038_JollyJumpers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] seq = new int[n];
            int[] dif = new int[n - 1];

            for (int i = 0; i < n; ++i)
                seq[i] = in.nextInt();

            for (int i = 0; i < n - 1; ++i)
                dif[i] = Math.abs(seq[i + 1] - seq[i]);
            Arrays.sort(dif);

            boolean valid = true;
            for (int i = 0; i < n - 1 && valid; ++i)
                if (dif[i] != i + 1) valid = false;

            System.out.println((!valid ? "Not j" : "J") + "olly");
        }
    }
}
