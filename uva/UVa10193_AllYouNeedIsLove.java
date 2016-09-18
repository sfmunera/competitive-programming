package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1134 (10193 - All You Need Is Love) */
/* SUBMISSION: 10165377 */
/* SUBMISSION TIME: 2012-05-28 18:31:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10193_AllYouNeedIsLove {

    static int toDec(String s) {
        int n = 0;
        int len = s.length();
        int pow = 1;

        for (int i = 0; i < len; ++i) {
            n += pow * (s.charAt(len - 1 - i) - '0');
            pow <<= 1;
        }

        return n;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        for (int t = 1; t <= N; ++t) {
            String S1 = in.readLine();
            String S2 = in.readLine();

            int n1 = toDec(S1);
            int n2 = toDec(S2);

            int gcd = gcd(n1, n2);

            if (gcd == 1)
                System.out.println("Pair #" + t + ": Love is not all you need!");
            else
                System.out.println("Pair #" + t + ": All you need is love!");
        }

        in.close();
        System.exit(0);
    }
}
