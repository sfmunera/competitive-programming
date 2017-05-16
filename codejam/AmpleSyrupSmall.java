package codejam;

import java.util.*;
import java.io.*;

public class AmpleSyrup {
    static final String FILENAME = "A";
    static Scanner in;
    static StringBuilder sb;

    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + sb);
    }
    
    static void solve(int t) {
        int N = in.nextInt();
        int K = in.nextInt();
        int[] R = new int[N];
        int[] H = new int[N];
        
        for (int i = 0; i < N; i++) {
            R[i] = in.nextInt();
            H[i] = in.nextInt();
        }
        
        int[] perm = new int[N];
        for (int i = 0; i < N; i++) {
            perm[i] = i;
        }
        
        double ans = 0.0;
        do {
            if (!isSorted(perm, R, H, K)) continue;
            double area = getArea(perm, R, H, K);
            ans = Math.max(ans, area);
        } while (nextPermutation(perm));
        
        sb.append(String.format("%.6f", ans));
        print(sb, t);
    }
    
    static double getArea(int[] perm, int[] R, int[] H, int K) {
        double area = 0.0;
        for (int i = 0; i < K; i++) {
            area += 2.0 * Math.PI * R[perm[i]] * H[perm[i]];
            area += Math.PI * R[perm[i]] * R[perm[i]];
            if (i > 0) {
                area -= Math.PI * R[perm[i - 1]] * R[perm[i - 1]];
            }
        }
        
        return area;
    }
    
    static boolean isSorted(int[] perm, int[] R, int[] H, int K) {
        // smaller first
        for (int i = 1; i < K; i++) {
            if (R[perm[i - 1]] > R[perm[i]]) return false;
        }
        return true;
    }

    static boolean nextPermutation(int[] c) {
        int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i)
            if (c[i] < c[i + 1]) {
                k = i;
                break;
            }
        if (k == -1) return false;
        int l = 0;
        for (int i = n - 1; i >= 0; --i)
            if (c[k] < c[i]) {
                l = i;
                break;
            }
        swap(c, k, l);
        for (int i = k + 1; i < (n + k + 1) / 2; ++i)
            swap(c, i, n + k - i);
        return true;
    }
    
    static void swap(int[] c, int i, int j) {
        int t = c[i];
        c[i] = c[j];
        c[j] = t;
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