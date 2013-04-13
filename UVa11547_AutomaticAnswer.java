package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2542 (11547 - Automatic Answer) */
/* SUBMISSION: 08789972 */
/* SUBMISSION TIME: 2011-04-28 18:56:44 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11547_AutomaticAnswer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();

            System.out.println((Math.abs((n * 567 / 9 + 7492) * 235 / 47 - 498) % 100) / 10);
        }
    }
}
