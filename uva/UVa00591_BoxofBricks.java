package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 532 (591 - Box of Bricks) */
/* SUBMISSION: 08268704 */
/* SUBMISSION TIME: 2010-09-22 03:45:53 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00591_BoxofBricks {
    public static void main(String args[]) {
        try {
            Scanner in = new Scanner(System.in);
            int n;
            int caseNo = 1;

            while (true) {
                n = in.nextInt();
                if (n == 0)
                    break;
                int[] s = new int[n];
                int sum = 0;
                int size;
                int min = 0;
                
                for (int i = 0; i < n; ++i) {
                    s[i] = in.nextInt();
                    sum += s[i];
                }
                size = sum / n;

                for (int i = 0; i < n; ++i) {
                   if (s[i] < size)
                       min += size - s[i];
                }
                System.out.println("Set #" + caseNo++);
                System.out.println("The minimum number of moves is " + min + ".");
                System.out.println("");
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}