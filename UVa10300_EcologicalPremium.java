package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1241 (10300 - Ecological Premium) */
/* SUBMISSION: 08510046 */
/* SUBMISSION TIME: 2011-01-14 18:41:19 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10300_EcologicalPremium {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            for (int i = 1; i <= n; ++i) {
                int sum = 0;
                int f = in.nextInt();
                for (int j = 1; j <= f; ++j) {
                    int size = in.nextInt();
                    int animals = in.nextInt();
                    int envf = in.nextInt();

                    sum += size * envf;
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
