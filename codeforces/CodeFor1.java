package codeforces;

import java.util.*;

public class CodeFor1 {
    
    static long getLength(long n) {
        if (n <= 1) return 1;
        return 1 + 2 * getLength(n / 2);
    }
    
    static long solve(long n, long l, long r, long len) {
        long index = len / 2;
        if (n == 0) return 0;
        if (n == 1) return (l <= index && index <= r) ? 1 : 0;
        if (l > r) return 0;
        int ans = (l <= index && index <= r) ? (int)n % 2 : 0;
        if (r <= index) {
            ans += solve(n / 2, l, r, len / 2);
        } else if (l >= index) {
            ans += solve(n / 2, l - index - 1, r - index - 1, len / 2);
        } else {
            ans += solve(n / 2, l, index - 1, len / 2);
            ans += solve(n / 2, 0, r - index - 1, len / 2);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        long n = in.nextLong();
        long l = in.nextLong() - 1;
        long r = in.nextLong() - 1;
        
        long len = getLength(n);
        System.out.println(solve(n, l, r, len));
        
        in.close();
        System.exit(0);
    }
}
