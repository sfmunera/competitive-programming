package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2423 (11428 - Cubes) */
/* SUBMISSION: 08790578 */
/* SUBMISSION TIME: 2011-04-29 00:27:01 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11428_Cubes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cubes = new int[100];
        for (int i = 0; i < 100; ++i)
            cubes[i] = i * i * i;

        while (true) {
            int N = in.nextInt();
            if (N == 0) break;

            boolean found = false;
            for (int y = 0; y < cubes.length && !found; ++y) {
                int cy = y * y * y;
                int cx = N + cy;
                int ind = Arrays.binarySearch(cubes, cx);
                if (ind >= 0) {
                    found = true;
                    System.out.println(ind + " " + y);
                }
            }
            if (!found)
                System.out.println("No solution");
        }
    }
}
