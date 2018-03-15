package codeforces;

import java.util.*;

public class PresentFromLena {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int max = 0;
        int d = 1;
        for (int i = 0; i <= 2 * n; i++) {
            int spaces = 2 * Math.abs(n - i);
            for (int s = 0; s < spaces; s++) System.out.print(" ");
            for (int j = 0; j <= max; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(j);
            }
            for (int j = max - 1; j >= 0; j--) {
                System.out.print(" " + j);
            }
            System.out.println();
            if (max >= n) d = -1;
            max += d;
        }
        
        in.close();
        System.exit(0);
    }
}
