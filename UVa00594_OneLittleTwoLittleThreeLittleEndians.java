package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 535 (594 - One Little, Two Little, Three Little Endians) */
/* SUBMISSION: 08574206 */
/* SUBMISSION TIME: 2011-02-12 23:51:27 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00594_OneLittleTwoLittleThreeLittleEndians {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextInt()) {
                int N = in.nextInt();
                System.out.println(N + " converts to " + Integer.reverseBytes(N));
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}