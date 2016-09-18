package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 72 (136 - Ugly Numbers) */
/* SUBMISSION: 09168091 */
/* SUBMISSION TIME: 2011-08-18 21:46:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00136_UglyNumbers {
    public static void main(String[] args) {
        long cur = 1;

        TreeSet<Long> ugly = new TreeSet<Long>();

        for (int i = 1; i < 1500; ++i) {
            ugly.add(cur * 2);
            ugly.add(cur * 3);
            ugly.add(cur * 5);

            cur = ugly.pollFirst();
        }
        System.out.println("The 1500'th ugly number is " + cur + ".");
    }
}
