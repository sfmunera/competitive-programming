package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1464 (10523 - Very Easy !!!) */
/* SUBMISSION: 08678990 */
/* SUBMISSION TIME: 2011-03-25 13:21:45 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa10523_VeryEasy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int N = in.nextInt();
            int A = in.nextInt();
            BigInteger res = BigInteger.ZERO;

            for (int i = 1; i <= N; ++i)
                res = res.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(A).pow(i)));
            System.out.println(res);
        }
    }
}