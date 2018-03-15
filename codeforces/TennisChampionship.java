package codeforces;

import java.util.*;

public class TennisChampionship {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        long n = in.nextLong();
        long prev = 1;
        long cur = 2;
        long index = 0;
        while (true) {
            if (cur >= n + 1) break;
            long next = prev + cur;
            index++;
            prev = cur;
            cur = next;
        }
        System.out.println(index);
        
        in.close();
        System.exit(0);
    }
}
