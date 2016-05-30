package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3769 (12347 - Binary Search Tree) */
/* SUBMISSION: 11529494 */
/* SUBMISSION TIME: 2013-03-30 03:22:43 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12347_BinarySearchTree {
	
	static class BST {
		private Node root;
		
		public BST() {
			root = null;
		}
		private class Node {
			int key;
			Node left;
			Node right;
			public Node(int key) {
				this.key = key;
				this.left = null;
				this.right = null;
			}
		}
		public void insert(int k) {
			if (root == null) {
				root = new Node(k);
				return;
			}
			Node node = root;
			while (node != null) {
				if (k < node.key)
					if (node.left == null) {
						node.left = new Node(k);
						return;
					} else
						node = node.left;
				else
					if (node.right == null) {
						node.right = new Node(k);
						return;
					} else
						node = node.right;
			}
		}
		private void postorderHelper(Node node) {
			if (node == null) return;
			postorderHelper(node.left);
			postorderHelper(node.right);
			System.out.println(node.key);
		}
		public void postorder() {
			postorderHelper(root);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BST t = new BST();
		String line;
		while ((line = in.readLine()) != null) {
			int x = Integer.parseInt(line);
			t.insert(x);
		}
		t.postorder();
		
		in.close();
		System.exit(0);
	}
}
