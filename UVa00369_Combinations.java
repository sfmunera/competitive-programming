package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 305 (369 - Combinations) */
/* SUBMISSION: 08813682 */
/* SUBMISSION TIME: 2011-05-05 15:05:45 */
/* LANGUAGE: 2 */

import java.math.BigInteger;
import java.util.*;

public class UVa00369_Combinations {

    static BigInteger factorial(int N) {
        if (N == 0) return BigInteger.ONE;
        return BigInteger.valueOf(N).multiply(factorial(N - 1));
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (true) {
                int N = in.nextInt();
                int M = in.nextInt();

                if (N == 0 && M == 0) break;
                BigInteger res = factorial(N).divide(factorial(N - M).multiply(factorial(M)));

                System.out.println(N + " things taken " + M + " at a time is " + res + " exactly.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
