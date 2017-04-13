package codejam;

import java.io.*;
import java.util.*;

public class OversizedPancakeFlipper {
    static Scanner in;
    
    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + sb);
    }
    
    static void solve(int t) {
        StringBuilder sb = new StringBuilder();
        
        char[] pancakes = in.next().toCharArray();
        int k = in.nextInt();

        int ans = 0;
        for (int i = 0; i < pancakes.length - k + 1; i++) {
            if (pancakes[i] == '-') {
                ans++;
                for (int j = i; j < i + k; j++) {
                    pancakes[j] = pancakes[j] == '-' ? '+' : '-';
                }
            }
        }
        boolean allUp = true;
        for (int i = pancakes.length - k + 1; i < pancakes.length; i++) {
            allUp &= pancakes[i] == '+';
        }
        sb.append(allUp ? ans : "IMPOSSIBLE");
        
        print(sb, t);
    }
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("A-large.in"));
        System.setOut(new PrintStream("A-large.out"));
        in = new Scanner(System.in);
        
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            solve(t);
        }
        
        in.close();
        System.exit(0);
    }
}
