package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1793 (10852 - Less Prime) */
/* SUBMISSION: 10165452 */
/* SUBMISSION TIME: 2012-05-28 18:56:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10852_LessPrime {

    static boolean[] sieve(int N) {
        boolean[] prime = new boolean[N + 1];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int p = 2; p * p <= N; ++p)
            if (prime[p])
                for (int i = p * p; i <= N; i += p)
                    prime[i] = false;
        return prime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = sieve(10005);
        List<Integer> primes = new ArrayList<Integer>();

        for (int i = 0; i < prime.length; ++i)
            if (prime[i])
                primes.add(i);

        int M = Integer.parseInt(in.readLine());
        while (M-- > 0) {
            int N = Integer.parseInt(in.readLine());

            int maxVal = 0;
            int maxX = 0;
            for (int i = 0; i < primes.size() && primes.get(i) <= N; ++i) {
                int x = primes.get(i);

                for (int p = 1; ; ++p) {
                    int val = N - p * x;
                    if (val >= 0 && val < x) {
                        if (val > maxVal) {
                            maxVal = val;
                            maxX = x;
                        }
                    } else
                        break;
                }
            }
            System.out.println(maxX);
        }

        in.close();
        System.exit(0);
    }
}
