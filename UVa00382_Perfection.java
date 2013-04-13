package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 318 (382 - Perfection) */
/* SUBMISSION: 08813726 */
/* SUBMISSION TIME: 2011-05-05 15:19:58 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00382_Perfection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();

        while (true) {
            int n = in.nextInt();
            if (n == 0) break;
            numbers.add(n);
        }

        System.out.println("PERFECTION OUTPUT");
        for (int i = 0; i < numbers.size(); ++i) {
            int sumdiv = 0;
            int n = numbers.get(i);
            for (int j = 1; j <= n / 2; ++j)
                if (n % j == 0)
                    sumdiv += j;
            System.out.printf("%5d  %s%n", n, sumdiv == n ? "PERFECT" : sumdiv > n ? "ABUNDANT" : "DEFICIENT");
        }
        System.out.println("END OF OUTPUT");
    }
}
