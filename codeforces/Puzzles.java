package codeforces;

import java.util.*;

public class Puzzles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        int[] f = new int[m];
        for (int i = 0; i < m; i++) {
            f[i] = in.nextInt();
        }
        Arrays.sort(f);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + n - 1 < m; i++) {
            min = Math.min(min, f[i + n - 1] - f[i]);
        }
        System.out.println(min);
        
        in.close();
        System.exit(0);
    }
}
