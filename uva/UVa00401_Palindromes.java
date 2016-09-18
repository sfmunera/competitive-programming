package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 342 (401 - Palindromes) */
/* SUBMISSION: 08517077 */
/* SUBMISSION TIME: 2011-01-18 03:32:10 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00401_Palindromes {

    public static String reverse(String s) {
        String rev = "";
        int n = s.length();

        for (int i = n - 1; i >= 0; --i)
           rev += s.charAt(i);
        return rev;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
            String mirror  = "A   3  HIL JM O   2TUVWXY51SE Z  8 ";

            while (in.hasNextLine()) {
                String str = in.nextLine().trim();
                boolean isPal = false;
                boolean isMir = false;

                if (str.equals(reverse(str))) isPal = true;

                String mir = "";
                for (int i = 0; i < str.length(); ++i)
                    for (int j = 0; j < mirror.length(); ++j)
                        if (str.charAt(i) == letters.charAt(j)) {
                            mir += mirror.charAt(j);
                            break;
                        }

                if (str.equals(reverse(mir))) isMir = true;

                System.out.print(str);
                if (!isPal && !isMir) System.out.println(" -- is not a palindrome.");
                if (isPal && !isMir) System.out.println(" -- is a regular palindrome.");
                if (!isPal && isMir) System.out.println(" -- is a mirrored string.");
                if (isPal && isMir)  System.out.println(" -- is a mirrored palindrome.");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}