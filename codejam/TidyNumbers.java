package codejam;

import java.io.*;
import java.util.*;

public class TidyNumbers {
    static Scanner in;
    
    static void print(StringBuilder sb, int t) {
        System.out.println("Case #" + t + ": " + sb);
    }
    
    static void solve(int t) {
        StringBuilder sb = new StringBuilder();
        
        char[] number = in.next().toCharArray();
        for (int i = 0; i < number.length - 1; i++) {
            if (number[i] > number[i + 1]) {
                int d = number[i];
                int j = i;
                while (j >= 0 && number[j] == d) {
                    number[j]--;
                    j--;
                }
                for (int k = j + 2; k < number.length; k++) {
                    number[k] = '9';
                }
                break;
            }
        }
        
        for (int i = number[0] == '0' ? 1 : 0; i < number.length; i++) {
            sb.append(number[i]);
        }
        
        print(sb, t);
    }
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("B-large.in"));
        System.setOut(new PrintStream("B-large.out"));
        in = new Scanner(System.in);
        
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            solve(t);
        }
        
        in.close();
        System.exit(0);
    }
}
