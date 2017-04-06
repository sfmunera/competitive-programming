package leetcode;

import java.util.*;

public class LC236_LowestCommonAncestorOfABinaryTree {
    /**
     * Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        List<TreeNode> pathFirst = new ArrayList<>();
        List<TreeNode> pathSecond = new ArrayList<>();
        findPath(root, first, pathFirst);
        findPath(root, second, pathSecond);
        
        return getLowestCommonAncestor(pathFirst, pathSecond);
    }
    
    private TreeNode getLowestCommonAncestor(List<TreeNode> pathFirst, List<TreeNode> pathSecond) {
        TreeNode lca = null;
        for (int i = 0; i < Math.min(pathFirst.size(), pathSecond.size()); i++) {
            if (!pathFirst.get(i).equals(pathSecond.get(i))) {
                break;
            }
            lca = pathFirst.get(i);
        }
        return lca;
    }
    
    private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.equals(node)
                || findPath(root.left, node, path)
                || findPath(root.right, node, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}