package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1012 (10071 - Back to High School Physics) */
/* SUBMISSION: 08510019 */
/* SUBMISSION TIME: 2011-01-14 18:27:49 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10071_BacktoHighSchoolPhysics {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int v = in.nextInt();
                int t = in.nextInt();
                System.out.println(2 * v * t);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
