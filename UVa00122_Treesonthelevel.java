package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 58 (122 - Trees on the level) */
/* SUBMISSION: 11535300 */
/* SUBMISSION TIME: 2013-03-31 07:01:35 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00122_Treesonthelevel {
	
	static Node root;
	
	static class Node {
		int key;
		Node left;
		Node right;
		public Node() {
			key = -1;
			left = right = null;
		}
		public void setKey(int k) {
			key = k;
		}
	}
	
	static boolean insert(int k, String path) {
		if (path.isEmpty()) {
			if (root.key != -1 && root.key != k)
				return false;
			root.setKey(k);
			return true;
		}
		Node node = root;
		for (int i = 0; i < path.length(); ++i) {
			if (path.charAt(i) == 'L') {
				if (node.left == null)
					node.left = new Node();
				node = node.left;
			} else {
				if (node.right == null)
					node.right = new Node();
				node = node.right;
			}
		}
		if (node.key != -1 && node.key != k)
			return false;
		node.setKey(k);
		return true;
	}
	
	static boolean valid(Node node) {
		if (node == null) return true;
		if (node.key == -1) return false;
		
		if (!valid(node.left) || !valid(node.right))
			return false;
		return true;
	}
	
	static void bfs() {
		Queue<Node> Q = new LinkedList<Node>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Node node = root;
		Q.offer(node);
		while (!Q.isEmpty()) {
			Node x = Q.poll();
			list.add(x.key);
			
			if (x.left != null)
				Q.offer(x.left);
			if (x.right != null)
				Q.offer(x.right);
		}
		for (int i = 0; i < list.size(); ++i) {
			if (i > 0) System.out.print(" ");
			System.out.print(list.get(i));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String token;
			ArrayList<String> tokens = new ArrayList<String>();
			while (in.hasNext() && !(token = in.next()).equals("()"))
				tokens.add(token);
			
			root = new Node();
			boolean ok = true;
			for (String s : tokens) {
				String[] parts = s.split(",");
				int k = Integer.parseInt(parts[0].substring(1));
				String path = parts[1].substring(0, parts[1].length() - 1);
				
				ok &= insert(k, path);
			}
			if (ok && !valid(root))
					ok = false;
			if (!ok)
				System.out.println("not complete");
			else
				bfs();
		}
		
		in.close();
		System.exit(0);
	}
}
