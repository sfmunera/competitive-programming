package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1222 (10281 - Average Speed) */
/* SUBMISSION: 08574119 */
/* SUBMISSION TIME: 2011-02-12 21:51:23 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10281_AverageSpeed {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            double speed = 0.0;
            double dist = 0.0;
            double tchange = 0.0;
            double dchange = 0.0;
            while (in.hasNextLine()) {
                String[] parts = in.nextLine().split("[ ]");

                String[] tstr = parts[0].split("[:]");
                double time = Double.parseDouble(tstr[0]) + Double.parseDouble(tstr[1]) / 60.0 +
                        Double.parseDouble(tstr[2]) / 3600.0;
                
                if (parts.length == 2) {
                    dchange += speed * (time - tchange);
                    speed = Double.parseDouble(parts[1]);
                    tchange = time;
                } else {
                    dist = dchange + speed * (time - tchange);
                    System.out.format(Locale.ENGLISH, "%s %.2f km%n", parts[0], dist);
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}