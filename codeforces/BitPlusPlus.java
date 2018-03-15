package codeforces;

import java.util.*;

public class BitPlusPlus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int X = 0;
        for (int i = 0; i < n; i++) {
            String statement = in.next();
            if (statement.contains("+")) {
                X++;
            } else {
                X--;
            }
        }
        System.out.println(X);
        
        in.close();
        System.exit(0);
    }
}
