package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 341 (400 - Unix ls) */
/* SUBMISSION: 08518488 */
/* SUBMISSION TIME: 2011-01-18 21:10:41 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00400_Unixls {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextLine()) {
                int n = Integer.parseInt(in.nextLine());
                String[] ls = new String[n];
                int maxlen = -1;

                for (int i = 0; i < n; ++i) {
                    ls[i] = in.nextLine();
                    if (ls[i].length() > maxlen) maxlen = ls[i].length();
                }
                Arrays.sort(ls);

                int c = 1 + (60 - maxlen) / (maxlen + 2);
                int gap = (int) Math.ceil((float)ls.length / (float)c);

                System.out.println("------------------------------------------------------------");
                for (int i = 0; i < gap; ++i) {
                    for (int j = 0; j < c; ++j) {
                        if (i + j * gap < ls.length) {
                            System.out.print(ls[i + j * gap]);
                            for (int k = 0; k < maxlen - ls[i + j * gap].length(); ++k)
                                System.out.print(" ");
                            if (j < c - 1) System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}