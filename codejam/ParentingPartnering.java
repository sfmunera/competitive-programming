package codejam;

import java.util.*;
import java.io.*;

public class ParentingPartnering {
    static final int MAX_MIN = 24 * 60;
    static final String FILENAME = "B";
    static Scanner in;
    static StringBuilder sb;
    static Integer[][][][] dp;
    
    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + sb);
    }
    
    static void solve(int t) {
        int Ac = in.nextInt();
        int Aj = in.nextInt();
        boolean[] C = new boolean[MAX_MIN];
        boolean[] J = new boolean[MAX_MIN];
        for (int i = 0; i < Ac; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            for (int j = begin; j < end; j++) {
                C[j] = true;
            }
        }
        for (int i = 0; i < Aj; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            for (int j = begin; j < end; j++) {
                J[j] = true;
            }
        }
        dp = new Integer[MAX_MIN + 1][2][2][MAX_MIN + 1];
        int ans = Math.min(go(0, true, true, 720, C, J), go(0, false, false, 720, C, J));
        sb.append(ans);
        
        print(sb, t);
    }
    
    static int go(int minute, boolean first, boolean prev /*false:C, true:J*/, int Cleft, boolean[] C, boolean[] J) {
        if (minute == MAX_MIN) {
            return Cleft == 0 ? (first != prev ? 1 : 0) : Integer.MAX_VALUE / 2;
        }
        if (dp[minute][first ? 1 : 0][prev ? 1 : 0][Cleft] != null) {
            return dp[minute][first ? 1 : 0][prev ? 1 : 0][Cleft];
        }
        int ans = Integer.MAX_VALUE / 2;
        if (C[minute]) {
            ans = Math.min(ans, (prev ? 0 : 1) + go(minute + 1, first, true, Cleft, C, J));
        } else if (J[minute]) {
            if (Cleft > 0) {
                ans = Math.min(ans, (prev ? 1 : 0) + go(minute + 1, first, false, Cleft - 1, C, J));
            }
        } else {
            ans = Math.min(ans, (prev ? 0 : 1) + go(minute + 1, first, true, Cleft, C, J));
            if (Cleft > 0) {
                ans = Math.min(ans, (prev ? 1 : 0) + go(minute + 1, first, false, Cleft - 1, C, J));
            }
        }
        return dp[minute][first ? 1 : 0][prev ? 1 : 0][Cleft] = ans;
    }
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(FILENAME + ".in"));
        System.setOut(new PrintStream(FILENAME + ".out"));
        in = new Scanner(System.in);
        
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            sb = new StringBuilder();
            solve(t);
        }
        
        in.close();
        System.exit(0);
    }
}