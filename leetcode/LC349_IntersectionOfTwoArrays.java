package leetcode;

import java.util.*;

public class LC349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> ansList = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);


		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums2[j] < nums1[i]) {
				j++;
			} else {
				int intersection = nums1[i];
				ansList.add(intersection);
				while (i < nums1.length && nums1[i] == intersection) {
					i++;
				}
				while (j < nums2.length && nums2[j] == intersection) {
					j++;
				}
			}
		}
		int[] ans = new int[ansList.size()];
		for (i = 0; i < ans.length; i++) {
			ans[i] = ansList.get(i);
		}
		return ans;
	}
}
