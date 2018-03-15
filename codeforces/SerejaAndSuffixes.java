package codeforces;

import java.util.*;

public class SerejaAndSuffixes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Set<Integer> unique = new HashSet<>();
        int[] cnt = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            unique.add(a[i]);
            cnt[i] = unique.size();
        }
        
        for (int i = 0; i < m; i++) {
            int l = in.nextInt() - 1;
            System.out.println(cnt[l]);
        }
        
        
        in.close();
        System.exit(0);
    }
}
