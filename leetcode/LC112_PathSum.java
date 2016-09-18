package leetcode;

public class LC112_PathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    boolean hasPathSumHelper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) return sum == root.val;
        
        boolean ans = false;
        if (root.left != null)
            ans |= hasPathSumHelper(root.left,  sum - root.val);
        if (root.right != null)
            ans |= hasPathSumHelper(root.right, sum - root.val);
        
        return ans;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        return hasPathSumHelper(root, sum);
    }
}