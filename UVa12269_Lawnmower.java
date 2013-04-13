package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3421 (12269 - Lawn mower) */
/* SUBMISSION: 09282778 */
/* SUBMISSION TIME: 2011-09-21 00:37:30 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa12269_Lawnmower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int nx = Integer.parseInt(in.next());
            int ny = Integer.parseInt(in.next());
            double w = Double.parseDouble(in.next());

            if (nx == 0 && ny == 0 && w == 0.0)
                break;

            double[] x = new double[nx];
            double[] y = new double[ny];

            for (int i = 0; i < nx; ++i)
                x[i] = Double.parseDouble(in.next());
            for (int i = 0; i < ny; ++i)
                y[i] = Double.parseDouble(in.next());
            Arrays.sort(x);
            Arrays.sort(y);
            boolean valid = true;

            if (x[0] - w / 2.0 > 0)
                valid = false;
            for (int i = 0; i < nx - 1 && valid; ++i)
                if (x[i] + w / 2.0 < x[i + 1] - w / 2.0)
                    valid = false;
            if (x[nx - 1] + w / 2.0 < 75)
                valid = false;

            if (y[0] - w / 2.0 > 0)
                valid = false;
            for (int i = 0; i < ny - 1 && valid; ++i)
                if (y[i] + w / 2.0 < y[i + 1] - w / 2.0)
                    valid = false;
            if (y[ny - 1] + w / 2.0 < 100)
                valid = false;
            System.out.println(valid ? "YES" : "NO");
        }
    }
}
