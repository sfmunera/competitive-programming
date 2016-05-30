package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 431 (490 - Rotating Sentences) */
/* SUBMISSION: 08510232 */
/* SUBMISSION TIME: 2011-01-14 20:22:17 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00490_RotatingSentences {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            ArrayList<String> sentences = new ArrayList<String>();

            while (in.hasNextLine())
                sentences.add(in.nextLine());

            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < sentences.size(); ++i)
                max = Math.max(max, sentences.get(i).length());

            for (int i = 0; i < max; ++i) {
                for (int j = sentences.size() - 1; j >= 0 ; --j)
                    if (sentences.get(j).length() > i)
                        System.out.print(sentences.get(j).charAt(i));
                    else System.out.print(" ");
                System.out.println();
            }

        } catch (Exception e) {
            System.exit(0);
        }
    }
}
