package codejam;

import java.util.*;
import java.io.*;

public class Steed2CruiseControl {
    static final double EPSILON = 1e-9;
    static final String FILENAME = "As";
    static Scanner in;
    static StringBuilder sb;

    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + sb);
    }
    
    static void solve(int t) {
        int D = in.nextInt();
        int N = in.nextInt();
        int[] K = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            K[i] = in.nextInt();
            S[i] = in.nextInt();
        }
        double low = EPSILON;
        double high = 1e18;
        double ans = 0.0;
        int cnt = 0;
        while (Math.abs(high - low) > EPSILON && cnt < 10000) {
            double mid = (low + high) / 2.0;
            if (check(mid, K, S, D)) {
                ans = mid;
                low = mid;
            } else {
                high = mid;
            }
            cnt++;
        }
        sb.append(String.format("%.6f", ans));
        
        print(sb, t);
    }
    
    static boolean check(double speed, int[] K, int[] S, int D) {
        double time = D / speed;
        for (int i = 0; i < K.length; i++) {
            double x = (double)K[i] + S[i] * time;
            if (x < D) {
                return false;
            }
        }
        return true;
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