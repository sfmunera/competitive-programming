package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 280 (344 - Roman Digititis) */
/* SUBMISSION: 08625789 */
/* SUBMISSION TIME: 2011-03-05 18:27:14 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00344_RomanDigititis {

    static String toRoman(int n) {
        String res = "";

        int mult = 1;

        while (n != 0) {
            int r = n % 10 * mult;
            switch (r) {
                case 1: res = "i" + res; break;
                case 2: res = "ii" + res; break;
                case 3: res = "iii" + res; break;
                case 4: res = "iv" + res; break;
                case 5: res = "v" + res; break;
                case 6: res = "vi" + res; break;
                case 7: res = "vii" + res; break;
                case 8: res = "viii" + res; break;
                case 9: res = "ix" + res; break;
                case 10: res = "x" + res; break;
                case 20: res = "xx" + res; break;
                case 30: res = "xxx" + res; break;
                case 40: res = "xl" + res; break;
                case 50: res = "l" + res; break;
                case 60: res = "lx" + res; break;
                case 70: res = "lxx" + res; break;
                case 80: res = "lxxx" + res; break;
                case 90: res = "xc" + res; break;
                case 100: res = "c" + res; break;
            }
            n /= 10;
            mult *= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) break;
            int[] cnt = new int[255];
            cnt['i'] = cnt['v'] = cnt['x'] = cnt['l'] = cnt['c'] = 0;

            for (int k = 1; k <= n; ++k) {
                String roman = toRoman(k);
                for (int i = 0; i < roman.length(); ++i)
                    ++cnt[roman.charAt(i)];
            }
            System.out.println(n + ": " + cnt['i'] + " i, " + cnt['v'] + " v, " +
                    cnt['x'] + " x, " + cnt['l'] + " l, " + cnt['c'] + " c");
        }
    }
}
