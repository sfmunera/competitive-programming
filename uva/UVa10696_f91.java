package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1637 (10696 - f91) */
/* SUBMISSION: 08813580 */
/* SUBMISSION TIME: 2011-05-05 14:30:55 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10696_f91 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        while (true) {
            int N = in.nextInt();
            if (N == 0) break;
            
            res.append("f91(");
            res.append(N);
            res.append(") = ");
            res.append((N <= 100) ? 91 : (N - 10));
            res.append("\n");
        }
        System.out.print(res);
    }
}
