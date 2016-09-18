package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 423 (482 - Permutation Arrays) */
/* SUBMISSION: 08574198 */
/* SUBMISSION TIME: 2011-02-12 23:36:58 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00482_PermutationArrays {

    static class Pair implements Comparable<Pair> {
        int i;
        String tok;

        Pair(int i, String tok) {
            this.i = i;
            this.tok = tok;
        }

        public int compareTo(Pair p) {
            return this.i - p.i;
        }
    }
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int N = Integer.parseInt(in.nextLine());

            for (int i = 0; i < N; ++i) {
                in.nextLine();
                String[] inds = in.nextLine().split("[ ]");
                String[] toks = in.nextLine().split("[ ]");
                ArrayList<Pair> pairs = new ArrayList<Pair>();
                int n = inds.length;

                for (int j = 0; j < n; ++j)
                    pairs.add(new Pair(Integer.parseInt(inds[j]), toks[j]));
                Collections.sort(pairs);

                for (int j = 0; j < n; ++j)
                    System.out.println(pairs.get(j).tok);
                if (i < N - 1) System.out.println();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}