package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 959 (10018 - Reverse and Add) */
/* SUBMISSION: 08793126 */
/* SUBMISSION TIME: 2011-04-29 16:25:59 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10018_ReverseandAdd {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int N = in.nextInt();
            while (N-- > 0) {
                long num = in.nextLong();

                int cnt = 0;
                while (true) {
                    String str = String.valueOf(num);
                    String tmp = "";

                    for (int i = 0; i < str.length(); ++i)
                        tmp += str.charAt(str.length() - i - 1);
                    long rev = Long.parseLong(tmp);

                    if (num == rev) break;
                    num += rev;
                    ++cnt;
                }
                System.out.println(cnt + " " + num);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
