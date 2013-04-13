package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 49 (113 - Power of Cryptography) */
/* SUBMISSION: 08518599 */
/* SUBMISSION TIME: 2011-01-18 23:37:54 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00113_PowerofCryptography {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (in.hasNextLine()) {
                int n = Integer.parseInt(in.nextLine());
                Double p = Double.parseDouble(in.nextLine());
                Double k = Math.exp(Math.log(p) / n);
                System.out.println(Math.round(k));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}