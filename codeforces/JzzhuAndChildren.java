package codeforces;

import java.util.*;

public class JzzhuAndChildren {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = in.nextInt();
        }
        
        int ans = 0;
        int index = 0;
        int cnt = 0;
        while (cnt < n) {
            if (children[index] > 0) {
                children[index] -= m;
                if (children[index] <= 0) {
                    ans = index;
                    cnt++;
                }
            }
            index = (index + 1) % n;
        }
        System.out.println((ans + 1));
        
        in.close();
        System.exit(0);
    }
}
