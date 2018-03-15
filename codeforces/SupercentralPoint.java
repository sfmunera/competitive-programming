package codeforces;

import java.util.*;

public class SupercentralPoint {
    
    static boolean isSupercentral(int[] x, int[] y, int i) {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        for (int j = 0; j < x.length; j++) {
            if (i == j) continue;
            if (y[j] == y[i] && x[j] < x[i]) left++;
            if (y[j] == y[i] && x[j] > x[i]) right++;
            if (x[j] == x[i] && y[j] < y[i]) down++;
            if (x[j] == x[i] && y[j] > y[i]) up++;
        }
        return up > 0 && down > 0 && left > 0 && right > 0;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (isSupercentral(x, y, i)) {
                ans++;
            }
        }
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }
}
