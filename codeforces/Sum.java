package codeforces;

import java.util.*;

public class Sum {
    
    static int getBase(int a, int b) {
        return Math.max(getBase(a), getBase(b));
    }
    
    static int getBase(int a) {
        int max = 0;
        while (a > 0) {
            max = Math.max(max, a % 10);
            a /= 10;
        }
        return max + 1;
    }
    
    static int getSumLength(int a, int b, int base) {
        int len = 0;
        int carry = 0;
        
        while (a > 0 || b > 0 || carry > 0) {
            int da = a % 10;
            int db = b % 10;
            int sum = da + db + carry;
            carry = sum / base;
            len++;
            a /= 10;
            b /= 10;
        }
        
        return len;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        
        int base = getBase(a, b);
        int ans = getSumLength(a, b, base);
        
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }
}
