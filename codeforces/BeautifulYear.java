package codeforces;

import java.util.*;

public class BeautifulYear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        
        int ans = year + 1;
        while (!hasDistinctDigits(ans)) ans++;
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }

    private static boolean hasDistinctDigits(int ans) {
        int[] count = new int[10];
        while (ans > 0) {
            count[ans % 10]++;
            ans /= 10;
        }
        for (int i = 0; i < 10; i++)
            if (count[i] > 1) return false;
        return true;
    }
}
