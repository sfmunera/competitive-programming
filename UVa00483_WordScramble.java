package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 424 (483 - Word Scramble) */
/* SUBMISSION: 08571948 */
/* SUBMISSION TIME: 2011-02-11 19:09:10 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00483_WordScramble {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] words = line.split("[ ]");
            for (int i = 0; i < words.length; ++i) {
                int n = words[i].length();
                char[] tmp = new char[n];
                for (int j = 0; j < n; ++j)
                    tmp[j] = words[i].charAt(n - j - 1);
                System.out.print(String.valueOf(tmp));
                if (i < words.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}