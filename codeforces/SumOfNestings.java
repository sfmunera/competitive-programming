package codeforces;

import java.util.*;

public class SumOfNestings {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        long n = in.nextLong();
        long k = in.nextLong();
        
        if (k > n * (n - 1) / 2) {
            System.out.println("Impossible");
        } else {
            long cnt = 1;
            long sum = 0;
            long repeat = 0;
            while (true) {
                if (k - sum <= cnt) {
                    repeat = k - sum;
                    break;
                }
                sum += cnt;
                cnt++;
            }
            int open = 0;
            for (int i = 1; i <= cnt; i++) {
                System.out.print("(");
                open++;
                if (i == repeat) {
                    System.out.print("()");
                    open++;
                }
            }
            for (int i = 1; i <= cnt; i++) {
                System.out.print(")");
            }
            for (int i = 0; i < n - open; i++) {
                System.out.print("()");
            }
            System.out.println();
        }
        
        in.close();
        System.exit(0);
    }
}
