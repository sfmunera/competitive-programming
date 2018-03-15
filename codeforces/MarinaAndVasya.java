package codeforces;

import java.util.*;

public class MarinaAndVasya {
    
    static boolean valid(char[] ans, char[] s, int x) {
        int cnt = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != s[i]) cnt++;
        }
        return cnt == x;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int x = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        int t = n - x;
        
        char[] ans = new char[n];
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n && t > 0; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                --t;
                ans[i] = s1.charAt(i);
                seen[i] = true;
            }
        }
        
        int turn = 0;
        for (int i = 0; i < n; i++) {
            if (seen[i]) continue;
            if (t > 0) {
                ans[i] = (turn == 0 ? s1 : s2).charAt(i);
                turn = 1 - turn;
                if (turn == 0) --t;
            } else {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != s1.charAt(i) && c != s2.charAt(i)) {
                        ans[i] = c;
                        break;
                    }
                }
            }
            
        }
        if (!valid(ans, s1.toCharArray(), x) || !valid(ans, s2.toCharArray(), x)) {
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(ans));
        }
        
        in.close();
        System.exit(0);
    }
}
