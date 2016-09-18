package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1862 (10921 - Find the Telephone) */
/* SUBMISSION: 08789444 */
/* SUBMISSION TIME: 2011-04-28 16:26:09 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10921_FindtheTelephone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] map = new char[256];
        map['-'] = '-';
        map['0'] = '0';
        map['1'] = '1';
        map['A'] = map['B'] = map['C'] = '2';
        map['D'] = map['E'] = map['F'] = '3';
        map['G'] = map['H'] = map['I'] = '4';
        map['J'] = map['K'] = map['L'] = '5';
        map['M'] = map['N'] = map['O'] = '6';
        map['P'] = map['Q'] = map['R'] = map['S'] = '7';
        map['T'] = map['U'] = map['V'] = '8';
        map['W'] = map['X'] = map['Y'] = map['Z'] = '9';

        while (in.hasNextLine()) {
            String exp = in.nextLine();
            for (int i = 0; i < exp.length(); ++i)
                System.out.print(map[exp.charAt(i)]);
            System.out.println();
        }
    }
}
