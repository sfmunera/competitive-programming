package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1414 (10473 - Simple Base Conversion) */
/* SUBMISSION: 08678966 */
/* SUBMISSION TIME: 2011-03-25 13:16:51 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10473_SimpleBaseConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String num = in.next();

            if (num.length() >= 2 && num.subSequence(0, 2).equals("0x"))
                System.out.println(Integer.valueOf(num.substring(2, num.length()), 16));
            else if (num.charAt(0) == '-') break;
            else
                System.out.println("0x" + Integer.toHexString(Integer.parseInt(num)).toUpperCase());
        }
    }
}
