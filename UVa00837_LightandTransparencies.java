package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 778 (837 - Light and Transparencies) */
/* SUBMISSION: 08574035 */
/* SUBMISSION TIME: 2011-02-12 20:32:31 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00837_LightandTransparencies {

    static class Line {
        private double xi;
        private double yi;
        private double xf;
        private double yf;
        private double r;

        public Line(double xi, double yi, double xf, double yf, double r) {
            this.xi = xi;
            this.yi = yi;
            this.xf = xf;
            this.yf = yf;
            this.r = r;
        }
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int N = Integer.parseInt(in.nextLine());

            for (int i = 0; i < N; ++i) {
                in.nextLine();
                int NL = Integer.parseInt(in.nextLine());
                Line[] lines = new Line[NL];
                List<Double> coords = new ArrayList<Double>();

                for (int j = 0; j < NL; ++j) {
                    String[] parts = in.nextLine().split("[ ]");
                    double x1 = Double.parseDouble(parts[0]);
                    double y1 = Double.parseDouble(parts[1]);
                    double x2 = Double.parseDouble(parts[2]);
                    double y2 = Double.parseDouble(parts[3]);
                    double r = Double.parseDouble(parts[4]);

                    if (!coords.contains(x1)) coords.add(x1);
                    if (!coords.contains(x2)) coords.add(x2);
                    if (x2 < x1) {
                        double tmp = x2;
                        x2 = x1;
                        x1 = tmp;
                        tmp = y2;
                        y2 = y1;
                        y1 = tmp;
                    }
                    lines[j] = new Line(x1, y1, x2, y2, r);
                }
                Collections.sort(coords);
                int NP = coords.size() + 1;
                System.out.println(NP);

                double res = 1.0;
                System.out.format(Locale.ENGLISH, "-inf %.3f %.3f%n", coords.get(0), res);
                for (int j = 1; j < NP - 1; ++j) {
                    res = 1.0;
                    double pi = coords.get(j - 1);
                    double pf = coords.get(j);
                    for (int k = 0; k < NL; ++k) {
                        if (pi >= lines[k].xi && pf <= lines[k].xf)
                            res *= lines[k].r;
                    }
                    System.out.format(Locale.ENGLISH, "%.3f %.3f %.3f%n", pi, pf, res);
                }
                res = 1.0;
                System.out.format(Locale.ENGLISH, "%.3f +inf %.3f%n", coords.get(NP - 2), res);
                if (i < N - 1) System.out.println();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}