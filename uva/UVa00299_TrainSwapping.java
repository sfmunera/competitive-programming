package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 235 (299 - Train Swapping) */
/* SUBMISSION: 08575796 */
/* SUBMISSION TIME: 2011-02-13 19:05:06 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00299_TrainSwapping {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int N = in.nextInt();
            for (int i = 0; i < N; ++i) {
                int L = in.nextInt();
                int[] wagons = new int[L];

                for (int j = 0; j < L; ++j)
                    wagons[j] = in.nextInt();

                int swaps = 0;
                int cur = 1;
                while (cur <= L) {
                    int ind = 0;

                    for (int k = 0; k < L; ++k)
                        if (wagons[k] == cur) {
                            ind = k;
                            break;
                        }
                    if (ind < cur - 1) {
                        for (int k = ind; k < cur - 1; ++k) {
                            int tmp = wagons[k];
                            wagons[k] = wagons[k + 1];
                            wagons[k + 1] = tmp;
                            ++swaps;
                        }
                    } else if (ind > cur - 1) {
                        for (int k = ind; k > cur - 1; --k) {
                            int tmp = wagons[k];
                            wagons[k] = wagons[k - 1];
                            wagons[k - 1] = tmp;
                            ++swaps;
                        }
                    }
                    ++cur;
                }
                System.out.println("Optimal train swapping takes " + swaps + " swaps.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}