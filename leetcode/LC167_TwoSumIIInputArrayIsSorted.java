package leetcode;

public class LC167_TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        
        int[] ans = new int[2];
        while (l < r) {
            int tmp = numbers[l] + numbers[r];
            if (tmp == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (tmp < target) {
                ++l;
            } else {
                --r;
            }
        }
        
        return ans;
    }
}
