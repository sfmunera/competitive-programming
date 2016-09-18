package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1704 (10763 - Foreign Exchange) */
/* SUBMISSION: 08516879 */
/* SUBMISSION TIME: 2011-01-17 22:56:42 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10763_ForeignExchange {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (true) {
                int n = in.nextInt();
                if (n == 0) break;

                int[] from = new int[n];
                int[] to = new int[n];
                for (int i = 0; i < n; ++i) {
                    from[i] = in.nextInt();
                    to[i] = in.nextInt();
                }

                Arrays.sort(from);
                Arrays.sort(to);

                boolean ok = true;
                for (int i = 0; i < n; ++i) {
                    if (from[i] != to[i]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) System.out.println("YES");
                else System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}