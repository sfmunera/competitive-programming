package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1191 (10250 - The Other Two Trees) */
/* SUBMISSION: 08518609 */
/* SUBMISSION TIME: 2011-01-19 00:32:57 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10250_TheOtherTwoTrees {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextDouble()) {
                double x1 = in.nextDouble();
                double y1 = in.nextDouble();
                double x2 = in.nextDouble();
                double y2 = in.nextDouble();

                double mx = (x1 + x2) / 2;
                double my = (y1 + y2) / 2;

                double dx = mx - x1;
                double dy = my - y1;
                double x1res = mx - dy, x2res = mx + dy, y1res = my + dx, y2res = my - dx;

                System.out.format("%.10f %.10f %.10f %.10f%n", x1res, y1res, x2res, y2res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}