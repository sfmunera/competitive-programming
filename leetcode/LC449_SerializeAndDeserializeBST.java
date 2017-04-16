package leetcode;

public class LC449_SerializeAndDeserializeBST {
    
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
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() > 0) sb.append(" ");
        sb.append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] parts = data.split(" ");
        int[] values = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }
        return deserialize(values, 0, values.length - 1);
    }
    
    private TreeNode deserialize(int[] data, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(data[left]);
        int index = left + 1;
        while (index <= right && data[index] <= data[left]) {
            index++;
        }
        root.left = deserialize(data, left + 1, index - 1);
        root.right = deserialize(data, index, right);
        return root;
    }
}
