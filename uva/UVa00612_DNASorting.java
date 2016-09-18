package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 553 (612 - DNA Sorting) */
/* SUBMISSION: 08575879 */
/* SUBMISSION TIME: 2011-02-13 20:59:01 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00612_DNASorting {

    static class DNA implements Comparable<DNA> {
        String dna;
        int sortedness;

        public DNA(String dna, int sortedness) {
            this.dna = dna;
            this.sortedness = sortedness;
        }

        public int compareTo(DNA o) {
            return this.sortedness - o.sortedness;
        }
    }
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int M = Integer.parseInt(in.nextLine());
            while (M > 0) {
                in.nextLine();
                String[] parts = in.nextLine().split("[ ]");
                int n = Integer.parseInt(parts[0]);
                int m = Integer.parseInt(parts[1]);

                DNA[] strings = new DNA[m];

                for (int i = 0; i < m; ++i) {
                    int sortedness = 0;
                    char[] string = in.nextLine().toCharArray();
                    for (int j = 0; j < n - 1; ++j)
                        for (int k = j + 1; k < n; ++k)
                            if (string[j] > string[k]) ++sortedness;
                    strings[i] = new DNA(String.valueOf(string), sortedness);
                }
                Arrays.sort(strings);
                for (int i = 0; i < m; ++i)
                    System.out.println(strings[i].dna);
                if (M > 1) System.out.println();
                --M;
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}