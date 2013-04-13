package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 92 (156 - Ananagrams) */
/* SUBMISSION: 08518432 */
/* SUBMISSION TIME: 2011-01-18 20:11:24 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00156_Ananagrams {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            ArrayList<String> dict = new ArrayList<String>();
            while (true) {
                String word = in.next();
                if (word.equals("#")) break;

                dict.add(word);
            }

            Collections.sort(dict);

            for (int i = 0; i < dict.size(); ++i) {
                char[] w1 = dict.get(i).toLowerCase().toCharArray();
                Arrays.sort(w1);
                boolean isanagram = false;

                for (int j = 0; j < dict.size(); ++j) {
                    if (i != j) {
                        char[] w2 = dict.get(j).toLowerCase().toCharArray();
                        Arrays.sort(w2);
                        if (String.valueOf(w1).equals(String.valueOf(w2))) {
                            isanagram = true;
                            break;
                        }
                    }
                }
                if (!isanagram) System.out.println(dict.get(i));
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.exit(0);
        }
    }
}