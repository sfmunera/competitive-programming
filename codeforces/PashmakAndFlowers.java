package codeforces;

import java.util.*;

public class PashmakAndFlowers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(b);
        int diff = b[n - 1] - b[0];
        long ways = 0;
        if (diff == 0) {
            ways = ((long)n * (n - 1)) / 2L;
        } else {
            int left = 0;
            int right = n - 1;
            while (b[left] == b[0]) {
                left++;
            }
            while (b[right] == b[n - 1]) {
                right--;
            }
            ways = (long)left * (n - 1 - right);
        }
        System.out.println(diff + " " + ways);
        
        in.close();
        System.exit(0);
    }
}
