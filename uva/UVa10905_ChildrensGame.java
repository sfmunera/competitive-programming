package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1846 (10905 - Children's Game) */
/* SUBMISSION: 08516852 */
/* SUBMISSION TIME: 2011-01-17 22:34:26 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10905_ChildrensGame {

    static class Num implements Comparable<Num> {
        char[] n;
        public Num(char[] n) {
            this.n = n;
        }

        public int compareTo(Num n) {            

            char[] N1 = this.n;
            char[] N2 = n.n;

            String s1 = String.valueOf(N1) + String.valueOf(N2);
            String s2 = String.valueOf(N2) + String.valueOf(N1);
            if (s1.compareTo(s2) > 0) return -1;
            if (s1.compareTo(s2) < 0) return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        try {
            //Scanner in = new Scanner(new File("input.txt"));
            //PrintWriter out = new PrintWriter(new File("output.txt"));

            Scanner in = new Scanner(System.in);

            while (true) {
                int N = in.nextInt();

                if (N == 0) break;

                ArrayList<Num> nums = new ArrayList<Num>();
                for (int i = 0; i < N; ++i)
                    nums.add(new Num(in.next().toCharArray()));

                Collections.sort(nums);

                for (int i = 0; i < N; ++i)
                    System.out.print(String.valueOf(nums.get(i).n));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}