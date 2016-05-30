package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 680 (739 - Soundex Indexing) */
/* SUBMISSION: 08573983 */
/* SUBMISSION TIME: 2011-02-12 19:26:54 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00739_SoundexIndexing {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            int[] code = new int[91];
            code['B'] = code['P'] = code['F'] = code['V'] = 1;
            code['C'] = code['S'] = code['K'] = code['G'] =
                    code['J'] = code['Q'] = code['X'] = code['Z'] = 2;
            code['D'] = code['T'] = 3;
            code['L'] = 4;
            code['M'] = code['N'] = 5;
            code['R'] = 6;
            String notCoded = "AEIOUYWH";
            System.out.println("         NAME                     SOUNDEX CODE");

            while (in.hasNextLine()) {
                char[] name = in.nextLine().toCharArray();
                String soundex = String.valueOf(name[0]);
                int k = 0;
                for (int i = 1; i < name.length; ++i) {
                    if (notCoded.contains(String.valueOf(name[i]))) continue;
                    if (code[name[i]] == code[name[i - 1]]) continue;
                    soundex += code[name[i]];
                    ++k;
                    if (k == 3) break;
                }
                for (int i = soundex.length(); i < 4; ++i)
                    soundex += '0';

                System.out.print("         " + String.valueOf(name));
                for (int i = 0; i < (35 - 9 - name.length - 1); ++i)
                    System.out.print(" ");
                System.out.println(soundex);
            }
            System.out.println("                   END OF OUTPUT");

        } catch (Exception e) {
            System.exit(0);
        }
    }
}