package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 291 (355 - The Bases Are Loaded) */
/* SUBMISSION: 08626239 */
/* SUBMISSION TIME: 2011-03-06 01:11:59 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00355_TheBasesAreLoaded {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String numbers = "0123456789ABCDEF";

            while (in.hasNext()) {
                int b1 = Integer.parseInt(in.next());
                int b2 = Integer.parseInt(in.next());
                String n = in.next();

                boolean ok = true;
                for (int i = 0; i < n.length(); ++i)
                    if (numbers.indexOf(n.charAt(i)) >= b1 || numbers.indexOf(n.charAt(i)) < 0) {
                        ok = false;
                        break;
                    }

                if (!ok) {
                    System.out.printf("%s is an illegal base %d number%n", n, b1);
                    continue;
                }
                long dec = 0;
                long mult = 1;
                for (int i = n.length() - 1; i >= 0; --i) {
                    dec += mult * numbers.indexOf(n.charAt(i));
                    mult *= b1;
                }

                String conv = "";
                if (dec == 0)
                    conv = "0";
                else {
                    while (dec != 0) {
                        conv = numbers.charAt((int)(dec % b2)) + conv;
                        dec /= b2;
                    }
                }
                System.out.printf("%s base %d = %s base %d%n", n, b1, conv, b2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
