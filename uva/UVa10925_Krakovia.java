package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1866 (10925 - Krakovia) */
/* SUBMISSION: 08679164 */
/* SUBMISSION TIME: 2011-03-25 14:01:33 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa10925_Krakovia {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int k = 1;
            while (true) {

                int N = Integer.parseInt(in.next());
                int F = Integer.parseInt(in.next());
                if (N == 0 && F == 0) break;

                BigInteger bill = BigInteger.ZERO;
                for (int i = 0; i < N; ++i)
                    bill = bill.add(new BigInteger(in.next()));
                System.out.printf("Bill #%d costs %s: each friend should pay %s%n%n",
                        k, bill, bill.divide(BigInteger.valueOf(F)));
                ++k;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
