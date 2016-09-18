package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1624 (10683 - The decadary watch) */
/* SUBMISSION: 09142706 */
/* SUBMISSION TIME: 2011-08-12 20:52:43 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10683_Thedecadarywatch {

    public static void main(String[] args) {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            long basedec = 100 * 100 * 10 * 100;
            long basesexa = 60 * 60 * 24 * 100;

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
            	long time = Integer.parseInt(line);
            	
            	long CC = time % 100;
            	time /= 100;
            	long SS = time % 100;
            	time /= 100;
            	long MM = time % 100;
            	time /= 100;
                long HH = time % 100;
                time /= 100;

                long timesexa = 100 * (HH * 3600 + MM * 60 + SS) + CC;
                long timedec = timesexa == 0 ? timesexa : timesexa * basedec / basesexa;

                CC = timedec % 100;
                timedec /= 100;
                SS = timedec % 100;
                timedec /= 100;
                MM = timedec % 100;
                timedec /= 100;
                HH = timedec % 10;
                timedec /= 10;
                sb.append(String.format("%1d%02d%02d%02d%n", HH, MM, SS, CC));
            }
            System.out.print(sb);
        } catch (Exception e) {
        	e.printStackTrace();
            System.exit(0);
        }
    }
}