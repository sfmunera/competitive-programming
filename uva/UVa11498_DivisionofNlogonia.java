package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2493 (11498 - Division of Nlogonia) */
/* SUBMISSION: 08789953 */
/* SUBMISSION TIME: 2011-04-28 18:51:17 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11498_DivisionofNlogonia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int K = in.nextInt();
            if (K == 0) break;

            int Xdiv = in.nextInt();
            int Ydiv = in.nextInt();

            for (int i = 0; i < K; ++i) {
                int X = in.nextInt();
                int Y = in.nextInt();
                if (X == Xdiv || Y == Ydiv)
                    System.out.println("divisa");
                else if (X > Xdiv) {
                    if (Y > Ydiv) System.out.println("NE");
                    else System.out.println("SE");
                } else {
                    if (Y > Ydiv) System.out.println("NO");
                    else System.out.println("SO");
                }
            }
        }
    }
}