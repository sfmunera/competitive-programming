package codeforces;

import java.util.*;

public class DevelopingSkills {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        for (int d = 1; d <= 9; d++) {
            for (int i = 0; i < n; i++) {
                if (a[i] < 100) {
                    int diff = (a[i] / 10 + 1) * 10 - a[i];
                    if (k >= d && diff == d) {
                        a[i] += d;
                        k -= d;
                    }
                }
            }
        }
        
        Arrays.sort(a);
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int add = Math.min(k, 100 - a[i]);
            a[i] += add;
            k -= add;
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long)a[i] / 10;
        }
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }
}
