package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 236 (300 - Maya Calendar) */
/* SUBMISSION: 08268708 */
/* SUBMISSION TIME: 2010-09-22 03:48:17 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00300_MayaCalendar {
    public static void main(String[] args)
    {
        try {
            int n, dayHaab, yearHaab, numberTzolkin, yearTzolkin;
            Scanner in = new Scanner(System.in);
            String s, monthHaab, dayTzolkin;;
            String[] monthsHaab = { "pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin",
                                    "mol", "chen", "yax", "zac", "ceh", "mac", "kankin",
                                    "muan", "pax", "koyab", "cumhu", "uayet" };
            String[] daysTzolkin = { "imix", "ik", "akbal", "kan", "chicchan", "cimi",
                                        "manik", "lamat", "muluk", "ok", "chuen", "eb",
                                        "ben", "ix", "mem", "cib", "caban", "eznab",
                                        "canac", "ahau" };            
            n = in.nextInt();
            System.out.println(n);

            for (int i=1; i<=n; i++) {
                int totalDays = 0, pos=0;
                s = in.next();
                dayHaab = Integer.parseInt(s.substring(0, s.length()-1));
                monthHaab = in.next();
                yearHaab = Integer.parseInt(in.next());
                totalDays += dayHaab;
                totalDays += yearHaab*365;
                for (int j=0; j<monthsHaab.length; j++) {
                    if (monthHaab.equals(monthsHaab[j])) {
                        pos = j;
                        break;
                    }
                }
                totalDays += 20*pos;

                yearTzolkin = totalDays/260;
                totalDays %= 260;
                numberTzolkin = totalDays%13+1;
                dayTzolkin = daysTzolkin[totalDays%20];

                System.out.println(numberTzolkin+" "+dayTzolkin+" "+yearTzolkin);
            }
        } catch(Exception e) {
            System.exit(0);
        }
    }
}