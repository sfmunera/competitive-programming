package leetcode;

import java.util.*;

public class LC204_CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p < n; p++)
            if (isPrime[p])
                for (int i = p * p; i < n; i += p)
                    isPrime[i] = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }
}
