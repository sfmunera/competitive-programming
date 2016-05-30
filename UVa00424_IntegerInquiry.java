package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 365 (424 - Integer Inquiry) */
/* SUBMISSION: 08518125 */
/* SUBMISSION TIME: 2011-01-18 16:30:11 */
/* LANGUAGE: 2 */

import java.math.*;
import java.util.*;

public class UVa00424_IntegerInquiry {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            BigInteger res = new BigInteger("0");

            while (true) {
                String line = in.nextLine();

                if (line.equals("0")) {
                    System.out.println(res);
                    break;
                }

                BigInteger num = new BigInteger(line);
                res = res.add(num);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}