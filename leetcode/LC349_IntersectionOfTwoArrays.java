package leetcode;

import java.util.*;

public class LC349_IntersectionOfTwoArrays {
    
    // Time: O(max(N lg N, N1 + N2)), Space: O(1) [does not include input/output data structures]
    // N : max(N1, N2)
	public int[] intersection1(int[] nums1, int[] nums2) {
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
	
	// Time: O(N), Space: O(N)
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums1) {
            seen.add(x);
        }
        List<Integer> intersection = new ArrayList<>();
        for (int x : nums2) {
            if (seen.contains(x)) {
                intersection.add(x);
                seen.remove(x);
            }
        }
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
