package leetcode;

import java.util.*;

public class LC414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        
        Set<Integer> distinct = new HashSet<Integer>();
        for (int x : nums) {
            distinct.add(x);
        }
        for (int x : distinct) {
            if (x > first) {
                third = second;
                second = first;
                first = x;
            } else if (x > second) {
                third = second;
                second = x;
            } else if (x > third) {
                third = x;
            }
        }
        return distinct.size() >= 3 ? third : first;
    }
}
