package codeforces;

import java.util.*;

public class Twins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] a = new int[n];
        
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        
        Arrays.sort(a);
        int cur = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (cur > sum - cur) {
                break;
            }
            cur += a[i];
            ++ans;
        }
        
        System.out.println(ans);
        
        in.close();
    }
}