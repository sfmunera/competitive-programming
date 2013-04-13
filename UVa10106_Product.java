package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1047 (10106 - Product) */
/* SUBMISSION: 08518131 */
/* SUBMISSION TIME: 2011-01-18 16:33:21 */
/* LANGUAGE: 2 */

import java.math.*;
import java.util.*;

public class UVa10106_Product {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextLine()) {
                BigInteger n1 = new BigInteger(in.nextLine());
                BigInteger n2 = new BigInteger(in.nextLine());

                System.out.println(n1.multiply(n2));
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}