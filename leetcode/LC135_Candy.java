package leetcode;

import java.util.*;

public class LC135_Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        
        for (int i = 0; i < ratings.length; ++i) {
            boolean isSink = true;
            if (i > 0 && ratings[i] > ratings[i - 1])
                isSink = false;
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1])
                isSink = false;
                
            if (isSink) {
                update(candies, ratings, i);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < ratings.length; ++i)
            ans += candies[i];
            
        return ans;
    }
    
    public void update(int[] candies, int[] ratings, int s) {
        Queue<Integer> Q = new LinkedList<Integer>();
        boolean[] seen = new boolean[ratings.length];

        Q.offer(s);
        candies[s] = 1;
        seen[s] = true;
        
        while (!Q.isEmpty()) {
            int x = Q.poll();
            if (x > 0 && ratings[x] < ratings[x - 1] && !seen[x - 1]) {
                seen[x - 1] = true;
                candies[x - 1] = Math.max(candies[x - 1], candies[x] + 1);
                Q.offer(x - 1);
            }
            
            if (x < ratings.length - 1 && ratings[x] < ratings[x + 1] && !seen[x + 1]) {
                seen[x + 1] = true;
                candies[x + 1] = Math.max(candies[x + 1], candies[x] + 1);
                Q.offer(x + 1);
            }
        }
    }
}
