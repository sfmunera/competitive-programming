package leetcode;

import java.util.*;

public class LC001_TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(target - nums[i])) {
                ans[0] = seen.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            seen.put(nums[i], i);
        }
        return ans;
    }
}
