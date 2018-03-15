package codeforces;

import java.util.*;

public class Team {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += in.nextInt();
            }
            if (sum >= 2) cnt++;
        }
        System.out.println(cnt);
        
        in.close();
        System.exit(0);
    }
}
