package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 516 (575 - Skew Binary) */
/* SUBMISSION: 08796324 */
/* SUBMISSION TIME: 2011-04-30 14:34:39 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00575_SkewBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String skew = in.nextLine();
            if (skew.equals("0")) break;

            int mult = 2;
            int dec = 0;
            for (int i = skew.length() - 1; i >= 0; --i) {
                dec += (skew.charAt(i) - '0') * (mult - 1);
                mult *= 2;
            }
            System.out.println(dec);
        }
    }
}
