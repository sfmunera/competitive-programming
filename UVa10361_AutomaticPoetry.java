package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1302 (10361 - Automatic Poetry) */
/* SUBMISSION: 08517180 */
/* SUBMISSION TIME: 2011-01-18 04:50:22 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10361_AutomaticPoetry {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int n = Integer.parseInt(in.nextLine());

            for (int i = 0; i < n; ++i) {
                String line1 = in.nextLine();
                String line2 = in.nextLine();

                String s1 = "";
                String s2 = "";
                String s3 = "";
                String s4 = "";
                String s5 = "";

                int j = 0;
                while (j < line1.length() && line1.charAt(j) != '<') {
                    s1 += line1.charAt(j);
                    ++j;
                }
                ++j;

                while (j < line1.length() && line1.charAt(j) != '>') {
                    s2 += line1.charAt(j);
                    ++j;
                }
                ++j;

                while (j < line1.length() && line1.charAt(j) != '<') {
                    s3 += line1.charAt(j);
                    ++j;
                }
                ++j;

                while (j < line1.length() && line1.charAt(j) != '>') {
                    s4 += line1.charAt(j);
                    ++j;
                }
                ++j;

                while (j < line1.length()) {
                    s5 += line1.charAt(j);
                    ++j;
                }

                System.out.println(s1 + s2 + s3 + s4 + s5);
                System.out.println(line2.substring(0, line2.length() - 3) + s4 + s3 + s2 + s5);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}