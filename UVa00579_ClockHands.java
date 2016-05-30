package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 520 (579 - ClockHands) */
/* SUBMISSION: 08518612 */
/* SUBMISSION TIME: 2011-01-19 00:51:29 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00579_ClockHands {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (true) {
                String line = in.nextLine();
                if (line.equals("0:00")) break;

                String[] time = line.split("[:]");
                double h = 30 * Integer.parseInt(time[0]);
                double m = 6 * Integer.parseInt(time[1]);

                h += m / 12;
                double res = Math.min(Math.abs(h - m), 360 - Math.abs(h - m));
                System.out.format(Locale.ENGLISH, "%.3f%n", res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}