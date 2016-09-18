package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 82 (146 - ID Codes) */
/* SUBMISSION: 08574488 */
/* SUBMISSION TIME: 2011-02-13 05:34:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00146_IDCodes {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            while (true) {
                char[] str = in.nextLine().toCharArray();
                if (String.valueOf(str).equals("#")) break;

                int k = -1;
                for (int i = 0; i < str.length - 1; ++i)
                    if (str[i] < str[i + 1]) k = i;
                if (k == -1) {
                    System.out.println("No Successor");
                    continue;
                }
                int l = 0;
                for (int i = k + 1; i < str.length; ++i)
                    if (str[k] < str[i]) l = i;
                char tmp = str[k];
                str[k] = str[l];
                str[l] = tmp;

                for (int i = k + 1; i < (str.length + k + 1) / 2; ++i) {
                    tmp = str[i];
                    str[i] = str[str.length - i + k];
                    str[str.length - i + k] = tmp;
                }
                System.out.println(String.valueOf(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}