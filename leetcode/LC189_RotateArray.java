package leetcode;

public class LC189_RotateArray {
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            ++l;
            --r;
        }
    }
    
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
