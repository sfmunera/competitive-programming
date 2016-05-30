package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QueriesForNumberOfPalindromes {
    
    static String s;
    static int[][] dp;
    static int[][] dp2;
    
    static int go(int l, int r) {
        if (l > r)
            return 0;
        if (l == r)
            return 1;

        if (dp[l][r] != -1)
            return dp[l][r];

        return dp[l][r] = (isPalindrome(l, r) ? 1 : 0) + go(l + 1, r) + go(l, r - 1) - go(l + 1, r - 1);
    }
    
    static boolean isPalindrome(int l, int r) {
        if (l >= r)
            return true;

        if (dp2[l][r] != -1)
            return dp2[l][r] == 1;

        return (dp2[l][r] = (s.charAt(l) == s.charAt(r) && isPalindrome(l + 1, r - 1)) ? 1 : 0) == 1;
    }
    
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        
        s = in.next();
        int n = s.length();
        dp = new int[n + 1][n + 1];
        dp2 = new int[n + 1][n + 1];
        
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(dp2[i], -1);
        }

        int q = in.nextInt();
        
        for (int i = 0; i < q; ++i) {
            int l = in.nextInt();
            int r = in.nextInt();
            
            System.out.println(go(l - 1, r - 1));
        }
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens())
                    tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
            return tokenizer.nextToken();
        }
        
        public String nextLine() {
            String line = null;
            try {
                tokenizer = null;
                line =  reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
