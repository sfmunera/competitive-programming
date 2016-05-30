package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 208 (272 - TEX Quotes) */
/* SUBMISSION: 08571897 */
/* SUBMISSION TIME: 2011-02-11 18:21:10 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00272_TEXQuotes {


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        boolean sw = true;
        while (in.hasNextLine()) {
            String txt = in.nextLine();

            for (int i = 0; i < txt.length(); ++i) {
                if (txt.charAt(i) == '"') {
                    if (sw) System.out.print("``");
                    else System.out.print("''");
                    sw = !sw;
                } else System.out.print(txt.charAt(i));
            }
            System.out.println();
        }

    }
}