package leetcode;

import java.util.*;

public class LC102_BinaryTreeLevelOrderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		if (root == null) return levels;

		Queue<TreeNode> Q = new LinkedList<>();
		Map<TreeNode, Integer> distance = new HashMap<>();
		Q.offer(root);
		distance.put(root, 0);

		while (!Q.isEmpty()) {
			TreeNode node = Q.poll();
			int d = distance.get(node);

			if (levels.size() == d) {
				levels.add(new ArrayList<Integer>());
			}
			levels.get(d).add(node.val);

			if (node.left != null) {
				Q.offer(node.left);
				distance.put(node.left, d + 1);
			}
			if (node.right != null) {
				Q.offer(node.right);
				distance.put(node.right, d + 1);
			}
		}

		return levels;
	}
}