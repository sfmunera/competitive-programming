package leetcode;

import java.util.*;

public class LC257_BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    String pathToString(Stack<TreeNode> path) {
        StringBuilder sb = new StringBuilder();
        
        boolean first = true;
        for (TreeNode x : path) {
            if (first) first = false;
            else sb.append("->");
            sb.append(x.val);
        }
        
        return sb.toString();
    }
    
    void binaryTreePathsHelper(TreeNode node, Stack<TreeNode> path, List<String> paths) {
        if (node == null) return;
        
        path.push(node);
        if (node.left == null && node.right == null) {
            paths.add(pathToString(path));
            path.pop();
            return;
        }
        
        if (node.left != null) {
            binaryTreePathsHelper(node.left, path, paths);
        }
        if (node.right != null) {
            binaryTreePathsHelper(node.right, path, paths);
        }
        
        path.pop();
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Stack<TreeNode> path = new Stack<>();
        
        binaryTreePathsHelper(root, path, paths);
        
        return paths;
    }
}
