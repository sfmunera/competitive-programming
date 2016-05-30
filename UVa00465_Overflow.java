package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 406 (465 - Overflow) */
/* SUBMISSION: 08518187 */
/* SUBMISSION TIME: 2011-01-18 17:04:20 */
/* LANGUAGE: 2 */

import java.math.*;
import java.util.*;

public class UVa00465_Overflow {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                String n1 = "";
                String n2 = "";

                int j = 0;
                while (j < line.length() && line.charAt(j) >= '0' &&
                        line.charAt(j) <= '9') {
                    n1 += line.charAt(j);
                    ++j;
                }
                while (j < line.length() && line.charAt(j) == ' ') ++j;

                char op = line.charAt(j);
                ++j;

                while (j < line.length() && line.charAt(j) == ' ') ++j;

                while (j < line.length() && line.charAt(j) >= '0' &&
                        line.charAt(j) <= '9') {
                    n2 += line.charAt(j);
                    ++j;
                }

                BigInteger N1 = new BigInteger(n1);
                BigInteger N2 = new BigInteger(n2);
                BigInteger N3;
                BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));

                if (op == '+') N3 = N1.add(N2);
                else N3 = N1.multiply(N2);

                System.out.println(line);

                if (N1.compareTo(max) > 0) System.out.println("first number too big");
                if (N2.compareTo(max) > 0) System.out.println("second number too big");
                if (N3.compareTo(max) > 0) System.out.println("result too big");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}