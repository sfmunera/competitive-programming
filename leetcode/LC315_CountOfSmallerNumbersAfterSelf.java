package leetcode;

import java.util.*;

public class LC315_CountOfSmallerNumbersAfterSelf {
	
	static class TreeNode {
		TreeNode left, right;
		int key, smaller;
		TreeNode(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
			this.smaller = 0;
		}
	}
	
	static int insert(int value, TreeNode node) {
		if (node == null) {
			node = new TreeNode(value);
			return 0;
		}
		
		int ans = 0;
		if (value < node.key) {
			node.smaller++;
			if (node.left == null) {
				node.left = new TreeNode(value);
			} else {
				ans += insert(value, node.left);
			}
		} else {
			ans = node.smaller + (node.key < value ? 1 : 0);
			if (node.right == null) {
				node.right = new TreeNode(value);
			} else {
				ans += insert(value, node.right);
			}
		}
		return ans;
	}
	
	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> cntSmaller = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) return cntSmaller;
		
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		cntSmaller.add(0);
		for (int i = nums.length - 2; i >= 0; --i) {
			int smaller = insert(nums[i], root);
			cntSmaller.add(smaller);
		}
		
		Collections.reverse(cntSmaller);

        return cntSmaller;
    }
	
	public static void main(String[] args) {
		System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
	}
}
