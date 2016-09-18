package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1361 (10420 - List of Conquests) */
/* SUBMISSION: 08518306 */
/* SUBMISSION TIME: 2011-01-18 18:30:41 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10420_ListofConquests {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int n = Integer.parseInt(in.nextLine());
            ArrayList<String> countries = new ArrayList<String>();

            for (int i = 0; i < n; ++i) {
                String line = in.nextLine();
                String[] parts = line.split("[ ]");
                countries.add(parts[0]);
            }

            Collections.sort(countries);

            String country = countries.get(0);
            int cnt = 1;
            for (int i = 1; i < n; ++i) {
                if (!countries.get(i).equals(country)) {
                    System.out.println(country + " " + cnt);
                    cnt = 1;
                    country = countries.get(i);
                } else ++cnt;
            }
            System.out.println(country + " " + cnt);
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}