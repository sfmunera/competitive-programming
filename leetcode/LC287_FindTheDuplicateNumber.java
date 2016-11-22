package leetcode;

public class LC287_FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int LEN = nums.length;
		int duplicate = -1;


		for (int i = 0; i < LEN; i++) {
			nums[nums[i] % LEN] += LEN;
		}
		for (int i = 0; i < LEN; i++) {
			if (nums[i] / LEN > 1) {
				duplicate = i;
			}
			nums[i] %= LEN;
		}
		return duplicate;
	}
}
