package leetcode;

import java.util.*;

public class LC199_BinaryTreeRightSideView {
    /**
     * Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) {
            return view;
        }
        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        
        while (!current.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            TreeNode last = null;
            while (!current.isEmpty()) {
                TreeNode node = current.poll();
                last = node;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            current = next;
            view.add(last.val);
        }
        return view;
    }
}
