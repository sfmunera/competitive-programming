package leetcode;

public class LC215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, k);
    }
    
    private int select(int[] nums, int left, int right, int k) {
        int pos = partition(nums, left, right);
        if (pos == nums.length - k) {
            return nums[pos];
        } else if (pos > nums.length - k) {
            return select(nums, left, pos - 1, k);
        } else {
            return select(nums, pos + 1, right, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int small = left + 1; // all numbers <= pivot are before small
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, small);
                small++;
            }
        }
        swap(nums, left, small - 1);
        return small - 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
