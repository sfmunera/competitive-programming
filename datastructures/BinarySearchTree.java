package datastructures;

public class BinarySearchTree {
	
	static class Node {
		int key;
		Node left;
		Node right;
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BST {
		private Node root;
		
		public BST() {
			root = null;
		}
		
		public void insert(int k, Node node) {
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
		
		public void insert(int k) {
			if (root == null) {
				root = new Node(k);
				return;
			}
			insert(k, root);
		}
		
		public Node minimum(Node node) {
			if (node == null) return null;
			while (node.left != null)
				node = node.left;
			return node;
		}
		
		public Node find(int k, Node node) {
			while (node != null) {
				if (node.key == k) return node;
				if (k < node.key)
					node = node.left;
				else
					node = node.right;
			}
			return null;
		}
		
		public boolean find(int k) {
			if (root == null) return false;
			
			return find(k, root) != null;
		}
		
		public boolean remove(int k, Node node) {
			Node parent = null;
			while (node != null) {
				if (k < node.key) {
					parent = node;
					node = node.left;
				} else if (k > node.key) {
					parent = node;
					node = node.right;
				} else { // found node
					if (node.left != null && node.right != null) { // two children
						Node successor = minimum(node.right);
						node.key = successor.key;
						remove(successor.key, node.right); // successor has 0 or 1 child
					} else { // 0 or 1 child
						Node x = node.left != null ? node.left : node.right;
						if (parent == null) root = x;
						else if (parent.left == node)
							parent.left = x;
						else
							parent.right = x;							
					}
					return true;
				}
			}
			return false;
		}
		
		public boolean remove(int k) {
			if (root == null) return false;
			
			return remove(k, root);
		}

		private void inorder(Node node) {
			if (node == null) return;
			
			inorder(node.left);
			System.out.print(node.key + " ");
			inorder(node.right);
		}
		public void inorder() {
			inorder(root);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] A = {-123, 3247, 0, 234, 6, -12334, 7873, 3, 10, 11, -100, 99, -1};
		
		BST T = new BST();
		for (int i = 0; i < A.length; ++i)
			T.insert(A[i]);
		T.inorder();
		
		int k = 3247;
		System.out.println("Key " + k + ": " + (T.find(k) ? "found" : "not found"));
		
		System.out.println();
		k = -12334;
		System.out.println("Remove " + k + ": " + (T.remove(k) ? "found" : "not found"));
		T.inorder();
		
		k = 7873;
		System.out.println("Remove " + k + ": " + (T.remove(k) ? "found" : "not found"));
		T.inorder();
		
		k = 0;
		System.out.println("Remove " + k + ": " + (T.remove(k) ? "found" : "not found"));
		T.inorder();
		
		k = 999;
		System.out.println("Remove " + k + ": " + (T.remove(k) ? "found" : "not found"));
		T.inorder();
		
		k = -123;
		System.out.println("Remove " + k + ": " + (T.remove(k) ? "found" : "not found"));
		T.inorder();
	}
}
