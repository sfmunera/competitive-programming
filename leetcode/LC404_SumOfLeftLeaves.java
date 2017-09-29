
public class LC404_SumOfLeftLeaves {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// Time: O(N), Space: O(N) [stack space]
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeavesHelper(root, false);
	}

	private int sumOfLeftLeavesHelper(TreeNode node, boolean isLeft) {
		if (node == null) return 0;
		if (node.left == null && node.right == null) {
			return isLeft ? node.val : 0;
		}

		return sumOfLeftLeavesHelper(node.left, true) + sumOfLeftLeavesHelper(node.right, false);
	}
}
