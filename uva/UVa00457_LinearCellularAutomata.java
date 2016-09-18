package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 398 (457 - Linear Cellular Automata) */
/* SUBMISSION: 08514045 */
/* SUBMISSION TIME: 2011-01-16 16:24:48 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00457_LinearCellularAutomata {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int n = in.nextInt();

            for (int i = 0; i < n; ++i) {
                in.nextLine();
                int[] DNA = new int[10];
                int[][] dishes = new int[50][40];
                dishes[0][19] = 1;

                for (int j = 0; j < 10; ++j)
                    DNA[j] = in.nextInt();

                for (int j = 0; j < 49; ++j) {
                    for (int k = 0; k < 40; ++k) {
                        int left = 0;
                        int right = 0;
                        if (k > 0) left = dishes[j][k - 1];
                        if (k < 39) right = dishes[j][k + 1];
                        dishes[j + 1][k] = DNA[dishes[j][k] + left + right];
                    }
                }

                for (int j = 0; j < 50; ++j) {
                    for (int k = 0; k < 40; ++k) {
                        switch (dishes[j][k]) {
                            case 0: System.out.print(" "); break;
                            case 1: System.out.print("."); break;
                            case 2: System.out.print("x"); break;
                            case 3: System.out.print("W"); break;
                        }
                    }
                    System.out.println();
                }
                if (i < n - 1)
                    System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}