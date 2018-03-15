package codejam;

import java.util.*;
import java.io.*;

public class AlphabetCake {
    static final String FILENAME = "A-large-practice";
    static Scanner in;
    static StringBuilder sb;

    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + sb);
    }
    
    static void solve(int t) {
        int R = in.nextInt();
        int C = in.nextInt();
        
        char[][] cake = new char[R][C];
        for (int i = 0; i < R; i++) {
            cake[i] = in.next().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cake[i][j] == '?') continue;
                int left = j - 1;
                while (left >= 0 && cake[i][left] == '?') {
                    cake[i][left] = cake[i][j];
                    left--;
                }
                int right = j + 1;
                while (right < C && cake[i][right] == '?') {
                    cake[i][right] = cake[i][j];
                    right++;
                }
            }
        }
        
        for (int i = 1; i < R; i++) {
            if (cake[i][0] == '?') {
                for (int j = 0; j < C; j++) {
                    cake[i][j] = cake[i - 1][j];
                }
            }
        }
        for (int i = R - 2; i >= 0; i--) {
            if (cake[i][0] == '?') {
                for (int j = 0; j < C; j++) {
                    cake[i][j] = cake[i + 1][j];
                }
            }
        }
        
        for (int i = 0; i < R; i++) {
            sb.append("\n" + String.valueOf(cake[i]));
        }
        
        print(sb, t);
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