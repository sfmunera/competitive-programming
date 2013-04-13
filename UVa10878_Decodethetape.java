package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1819 (10878 - Decode the tape) */
/* SUBMISSION: 08518094 */
/* SUBMISSION TIME: 2011-01-18 16:16:26 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10878_Decodethetape {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            in.nextLine();
            String res = "";

            while (true) {
                String line = in.nextLine();
                if (line.equals("___________")) break;

                int bits = 0;
                int mult = 1 << 7;
                for (int i = 1; i < 10; ++i) {
                    if (line.charAt(i) == '.') continue;
                    if (line.charAt(i) == 'o') bits += mult;
                    mult /= 2;
                }
                res += (char)bits;
            }
            System.out.print(res);
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}