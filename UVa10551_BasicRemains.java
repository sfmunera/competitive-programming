package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1492 (10551 - Basic Remains) */
/* SUBMISSION: 08927666 */
/* SUBMISSION TIME: 2011-06-07 21:16:37 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa10551_BasicRemains {

    static String toBase(BigInteger n, BigInteger b) {
        if (n.equals(BigInteger.ZERO))
        	return "0";
        String res = "";
        while (n.compareTo(BigInteger.ZERO) != 0) {
            res = n.mod(b) + res;
            n = n.divide(b);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int b = Integer.parseInt(in.next());
            if (b == 0) break;
            BigInteger p = new BigInteger(in.next(), b);
            BigInteger m = new BigInteger(in.next(), b);

            System.out.println(toBase(p.mod(m), BigInteger.valueOf(b)));
        }
    }
}