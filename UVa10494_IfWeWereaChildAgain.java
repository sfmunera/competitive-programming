package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1435 (10494 - If We Were a Child Again) */
/* SUBMISSION: 08518238 */
/* SUBMISSION TIME: 2011-01-18 17:40:41 */
/* LANGUAGE: 2 */

import java.math.*;
import java.util.*;

public class UVa10494_IfWeWereaChildAgain {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNext()) {
                BigInteger n1 = new BigInteger(in.next());
                String op = in.next();
                BigInteger n2 = new BigInteger(in.next());
                BigInteger res = new BigInteger("0");

                if (op.equals("/")) res = n1.divide(n2);
                if (op.equals("%")) res = n1.mod(n2);
                System.out.println(res);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}