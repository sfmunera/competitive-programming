package codejam;

import java.util.*;
import java.io.*;

public class StableNeighbors {
    static boolean done;
    static String ans;
    static boolean[][][][][] seen;
    static final int[][] mappings = {{1, 2}, {0, 2}, {0, 1}};
    static final String FILENAME = "B";
    static Scanner in;
    static StringBuilder sb;

    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + (ans.isEmpty() ? "IMPOSSIBLE" : ans));
    }
    
    static void solve(int t) {
        int N = in.nextInt();
        int R = in.nextInt();
        int O = in.nextInt();
        int Y = in.nextInt();
        int G = in.nextInt();
        int B = in.nextInt();
        int V = in.nextInt();
        done = false;
        ans = "";
        seen = new boolean[3][3][R+1][Y+1][B+1];
        sb.setLength(0);
        
        int[] cnt = {R, Y, B};
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0 && !done) {
                cnt[i]--;
                sb.append(numToChar(i));
                go(i, i, cnt[0], cnt[1], cnt[2]);
                sb.deleteCharAt(sb.length() - 1);
                cnt[i]++;
            }
        }
        print(sb, t);
    }
    
    static char numToChar(int num) {
        if (num == 0) return 'R';
        if (num == 1) return 'Y';
        return 'B';
    }
    
    static void go(int first, int prev, int R, int Y, int B) {
        if (done) return;
        if (seen[first][prev][R][Y][B]) return;
        seen[first][prev][R][Y][B] = true;
        if (R == 0 && Y == 0 && B == 0) {
            for (int i = 0; i < mappings[prev].length; i++) {
                if (mappings[prev][i] == first) {
                    done = true;
                    ans = sb.toString();
                    break;
                }
            }
        } else {
            int[] cnt = {R, Y, B};
            for (int i = 0; i < mappings[prev].length; i++) {
                int next = mappings[prev][i];
                if (cnt[next] > 0) {
                    cnt[next]--;
                    sb.append(numToChar(next));
                    go(first, next, cnt[0], cnt[1], cnt[2]);
                    sb.deleteCharAt(sb.length() - 1);
                    cnt[next]++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(FILENAME + ".in"));
        System.setOut(new PrintStream(FILENAME + ".out"));
        in = new Scanner(System.in);
        sb = new StringBuilder();
        
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            solve(t);
        }
        
        in.close();
        System.exit(0);
    }
}