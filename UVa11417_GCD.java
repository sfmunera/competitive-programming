package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2412 (11417 - GCD) */
/* SUBMISSION: 08790687 */
/* SUBMISSION TIME: 2011-04-29 02:15:09 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11417_GCD {

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int n = in.nextInt();
            if (n == 0) break;

            int G = 0;
            for (int i = 1; i < n; ++i)
                for (int j = i + 1; j <= n; ++j)
                    G += gcd(i, j);
            System.out.println(G);
        }
    }
}
