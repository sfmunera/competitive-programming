package codeforces;

import java.util.*;

public class VasyaAndTheBus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        if (n == 0 && m > 0) {
            System.out.println("Impossible");
        } else {
            int min = n + Math.max(0, m - n);
            int max = n + Math.max(0, m - 1);
            System.out.println(min + " " + max);
        }
        
        in.close();
        System.exit(0);
    }
}
