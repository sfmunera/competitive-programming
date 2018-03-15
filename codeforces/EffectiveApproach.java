package codeforces;

import java.util.*;

public class EffectiveApproach {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] numbers = new int[n];
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt() - 1;
            position[numbers[i]] = i;
        }
        
        long cntLeft = 0;
        long cntRight = 0;
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int q = in.nextInt() - 1;
            cntLeft += (long)position[q] + 1;
            cntRight += (long)n - position[q];
        }
        System.out.println(cntLeft + " " + cntRight);
        
        in.close();
        System.exit(0);
    }
}