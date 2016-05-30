package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 387 (446 - Kibbles "n" Bits "n" Bits "n" Bits) */
/* SUBMISSION: 08626257 */
/* SUBMISSION TIME: 2011-03-06 01:33:14 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00446_KibblesnBitsnBitsnBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; ++i) {
            String[] parts = in.nextLine().split(" ");
            int n1 = Integer.valueOf(parts[0], 16);
            int n2 = Integer.valueOf(parts[2], 16);
            char op = parts[1].charAt(0);

            int res = 0;
            if (op == '+')
                res = n1 + n2;
            else
                res = n1 - n2;
            String bin1 = Integer.toBinaryString(n1);
            while (bin1.length() < 13)
                bin1 = "0" + bin1;
            
            String bin2 = Integer.toBinaryString(n2);
            while (bin2.length() < 13)
                bin2 = "0" + bin2;

            System.out.printf("%s %c %s = %d%n", bin1, op, bin2, res);
        }
    }
}