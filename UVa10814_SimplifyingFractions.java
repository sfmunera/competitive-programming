package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1755 (10814 - Simplifying Fractions) */
/* SUBMISSION: 08679118 */
/* SUBMISSION TIME: 2011-03-25 13:52:39 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa10814_SimplifyingFractions {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int n = Integer.parseInt(in.next());
            while (n > 0) {
                BigInteger p = new BigInteger(in.next());
                in.next();
                BigInteger q = new BigInteger(in.next());
                BigInteger gcd = p.gcd(q);
                p = p.divide(gcd);
                q = q.divide(gcd);

                System.out.println(p + " / " + q);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
