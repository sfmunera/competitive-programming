package codeforces;

import java.util.*;

public class FlippingGame {
    
    static void flip(int[] a, int i, int j) {
        for (int k = i; k <= j; k++) {
            a[k] = 1 - a[k];
        }
    }
    
    static int countOnes(int[] a) {
        int cnt = 0;
        for (int x : a) {
            cnt += x;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                flip(a, i, j);
                max = Math.max(max, countOnes(a));
                flip(a, i, j);
            }
        }
        System.out.println(max);
        
        in.close();
        System.exit(0);
    }
}
