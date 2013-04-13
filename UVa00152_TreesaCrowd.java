package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 88 (152 - Tree's a Crowd) */
/* SUBMISSION: 08518367 */
/* SUBMISSION TIME: 2011-01-18 19:27:06 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00152_TreesaCrowd {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            ArrayList<Integer> X = new ArrayList<Integer>();
            ArrayList<Integer> Y = new ArrayList<Integer>();
            ArrayList<Integer> Z = new ArrayList<Integer>();
            int[] cnt = new int[10];

            while (true) {
                int x, y, z;
                x = in.nextInt();
                y = in.nextInt();
                z = in.nextInt();

                if (x == 0 && y == 0 && z == 0) break;

                X.add(x);
                Y.add(y);
                Z.add(z);
            }

            for (int i = 0; i < X.size(); ++i) {
                double min = Double.MAX_VALUE;
                for (int j = 0; j < X.size(); ++j) {
                    if (i != j) {
                        int x1 = X.get(i);
                        int x2 = X.get(j);
                        int y1 = Y.get(i);
                        int y2 = Y.get(j);
                        int z1 = Z.get(i);
                        int z2 = Z.get(j);

                        double d = Math.sqrt((x2 - x1) * (x2 - x1) +
                                (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
                        min = Math.min(min, d);
                    }
                }
                if (min < 10) ++cnt[(int)min];
            }

            for (int i = 0; i < cnt.length; ++i)
                System.out.format("%4d", cnt[i]);
            System.out.println();
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}