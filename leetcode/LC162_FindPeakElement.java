
public class LC162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isPeak = true;
            isPeak &= i == 0 || nums[i - 1] < nums[i];
            isPeak &= i == nums.length - 1 || nums[i + 1] < nums[i];
            if (isPeak) return i;
        }
        return -1;
    }
}
