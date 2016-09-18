package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 949 (10008 - What's Cryptanalysis?) */
/* SUBMISSION: 08796285 */
/* SUBMISSION TIME: 2011-04-30 14:25:07 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10008_WhatsCryptanalysis {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] freq = new int[256];

        int N = Integer.parseInt(in.nextLine());
        String txt = "";
        while (N-- > 0) txt += in.nextLine();

        for (int i = 0; i < txt.length(); ++i) {
            char c = txt.charAt(i);
            if (Character.isLetter(c)) c = Character.toUpperCase(c);
            ++freq[c];
        }
        for (int i = 1; i <= 26; ++i) {
            int max = 0;
            char cmax = ' ';
            for (char c = 'A'; c <= 'Z'; ++c) {
                if (freq[c] > max) {
                    max = freq[c];
                    cmax = c;
                }
            }
            if (max > 0) {
                System.out.println(cmax + " " + max);
                freq[cmax] = 0;
            }
        }
    }
}
