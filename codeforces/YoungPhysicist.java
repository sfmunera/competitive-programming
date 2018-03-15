package codeforces;

import java.util.*;

public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int sumX = 0;
        int sumY = 0;
        int sumZ = 0;
        for (int i = 0; i < n; i++) {
            sumX += in.nextInt();
            sumY += in.nextInt();
            sumZ += in.nextInt();
        }
        if (sumX == 0 && sumY == 0 && sumZ == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        in.close();
        System.exit(0);
    }
}
