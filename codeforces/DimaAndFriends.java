package codeforces;

import java.util.*;

public class DimaAndFriends {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int fingers = 0;
        for (int i = 0; i < n; i++) {
            fingers += in.nextInt();
        }
        
        int ans = 0;
        for (int f = 1; f <= 5; f++) {
            if ((f + fingers - 1) % (n + 1) > 0) {
                ans++;
            }
        }
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }
}
