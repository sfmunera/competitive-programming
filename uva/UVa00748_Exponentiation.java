package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 689 (748 - Exponentiation) */
/* SUBMISSION: 08518227 */
/* SUBMISSION TIME: 2011-01-18 17:31:26 */
/* LANGUAGE: 2 */

import java.math.*;
import java.util.*;

public class UVa00748_Exponentiation {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNext()) {
                String Rin = in.next();
                String[] parts = Rin.split("[.]");
                String nin = in.next();
                int dec = 0;
                BigInteger R;
                int n = Integer.parseInt(nin);
                String res = "";

                if (parts.length == 2) {
                    dec = parts[1].length() * n;
                    R = new BigInteger(parts[0] + parts[1]);
                } else R = new BigInteger(Rin);
                BigInteger pow = R.pow(n);

                res = pow.toString();

                if (dec > 0) {
                    int m = res.length() - dec;

                    if (m > 0)
                        res = res.substring(0, m) + "." + res.substring(m, res.length());
                    else {
                        String tmp = res;
                        res = ".";
                        for (int i = 0; i < Math.abs(m); ++i)
                            res += '0';
                        res += tmp;
                    }
                }
                int trail = 0;
                int k = res.length() - 1;

                while (k >= 0 && res.charAt(k) == '0') {
                    ++trail;
                    --k;
                }
                res = res.substring(0, res.length() - trail);
                System.out.println(res);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}