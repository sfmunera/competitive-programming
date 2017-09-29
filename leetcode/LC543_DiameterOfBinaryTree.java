public class LC543_DiameterOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// Time: O(N), Space: O(N) [stack space]
    public int diameterOfBinaryTree(TreeNode root) {
    	if (root == null) {
            return 0;
        } else {
            int diameterLeft = diameterOfBinaryTree(root.left);
            int diameterRight = diameterOfBinaryTree(root.right);
            int diameterCrossing = findLongest(root.left) + findLongest(root.right);
    	    return Math.max(Math.max(diameterLeft, diameterRight), diameterCrossing);
        }
    }
    
    private int findLongest(TreeNode node) {
    	if (node == null) {
            return 0;
        } else if (node.right == null && node.left == null) {
            return 1;
        } else {
            return 1 + Math.max(findLongest(node.left), findLongest(node.right));
        }
    }
}
