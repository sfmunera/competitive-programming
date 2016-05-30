package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 514 (573 - The Snail) */
/* SUBMISSION: 08571991 */
/* SUBMISSION TIME: 2011-02-11 19:46:22 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00573_TheSnail {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        while (true) {
            double H = in.nextInt();
            double U = in.nextInt();
            double D = in.nextInt();
            double F = in.nextInt();

            if (H == 0) break;

            int k = 1;
            double loss = U * F / 100.0;
            double dist = 0;

            while (true) {
                
                if (U >= 0)
                    dist += U;
                if (dist > H) {
                    System.out.println("success on day " + k);
                    break;
                }
                dist -= D;
                if (dist < 0) {
                    System.out.println("failure on day " + k);
                    break;
                }

                U -= loss;
                ++k;
            }
        }
    }
}