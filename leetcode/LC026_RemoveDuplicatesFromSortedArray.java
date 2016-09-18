package leetcode;

public class LC026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int origLen = nums.length;
        for (int i = 0; i < origLen - 1; ++i) {
            int offset = 0;
            for (int j = i + 1; j < origLen && nums[i] == nums[j]; ++j) {
                ++offset;
            }
            
            if (offset > 0) {
                for (int j = i + 1; j < origLen - offset; ++j) {
                    nums[j] = nums[j + offset];
                }
                origLen -= offset;
            }
        }
        
        return origLen;
    }
}