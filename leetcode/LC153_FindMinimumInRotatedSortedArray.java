package leetcode;

public class LC153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        int min = Integer.MAX_VALUE;
        while (low <= high) {
        	if (nums[low] <= nums[high]) {
        		min = Math.min(min, nums[low]);
        		break;
        	} else {
        		int mid = (low + high) / 2;
        		if (nums[low] > nums[mid]) {
        		    min = Math.min(min, nums[mid]);
        			high = mid - 1;
        		} else {
        			low = mid + 1;
        		}
        	}
        }
        
        return min;
    }
}
