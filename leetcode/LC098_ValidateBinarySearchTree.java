package leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LC098_ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBSTHelper(TreeNode node, long min, long max) {
		if (node == null)
			return true;

		if (node.val <= min || node.val >= max)
			return false;

		return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
	}
}
