package leetcode;

import java.util.*;

public class LC238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        
        int product = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output[i] *= product;
            product *= nums[i];
        }
        product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] *= product;
            product *= nums[i];
        }
        
        return output;
    }
}
