package codeforces;

import java.util.*;

public class FreeCash {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int maxRun = 0;
        int cnt = 0;
        int prevTime = -1;
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int m = in.nextInt();
            int time = 60 * h + m;
            if (time != prevTime) {
                maxRun = Math.max(maxRun, cnt);
                cnt = 0;
            }
            cnt++;
            prevTime = time;
        }
        maxRun = Math.max(maxRun, cnt);
        System.out.println(maxRun);
        
        in.close();
        System.exit(0);
    }
}
