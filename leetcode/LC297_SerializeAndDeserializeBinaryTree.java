package leetcode;

import java.util.*;

public class LC297_SerializeAndDeserializeBinaryTree {
    /**
     * Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                Q.add(node.left);
                Q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] parts = data.split(" ");
        if (parts[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        boolean nextLeft = true;
        for (int i = 1; i < parts.length; i++) {
            TreeNode node = parts[i].equals("null") ? null : new TreeNode(Integer.parseInt(parts[i]));
            while (!Q.isEmpty() && Q.peek() == null) {
                Q.poll();
            }
            if (!Q.isEmpty()) {
                TreeNode current = Q.peek();
                if (nextLeft) {
                    current.left = node;
                    nextLeft = false;
                } else {
                    current.right = node;
                    Q.poll();
                    nextLeft = true;
                }
                Q.add(node);
            }
        }
        return root;
    }
}

//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.deserialize(codec.serialize(root));
