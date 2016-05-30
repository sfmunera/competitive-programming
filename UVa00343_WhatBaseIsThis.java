package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 279 (343 - What Base Is This?) */
/* SUBMISSION: 08675996 */
/* SUBMISSION TIME: 2011-03-24 14:03:48 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00343_WhatBaseIsThis {

    static long toDecimal(String n, int b) {
        String numbers = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        long res = 0;
        int mult = 1;

        for (int i = n.length() - 1; i >= 0; --i) {
            int ind = numbers.indexOf(n.charAt(i));
            if (ind >= b) return -1;
            res += mult * ind;
            mult *= b;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {
            String n1 = in.next();
            String n2 = in.next();
            boolean ok = false;

            for (int b1 = 2; b1 <= 36 && !ok; ++b1) {
                for (int b2 = 2; b2 <= 36 && !ok; ++b2) {
                    long res1 = toDecimal(n1, b1);
                    long res2 = toDecimal(n2, b2);
                    if (res1 != -1 && res2 != -1 && res1 == res2) {
                        ok = true;
                        System.out.printf("%s (base %d) = %s (base %d)%n", n1, b1, n2, b2);
                    }
                }
            }
            if (!ok)
                System.out.printf("%s is not equal to %s in any base 2..36%n", n1, n2);
        }
    }
}