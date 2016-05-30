package eafit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BST {
	
	static int C;
	
	static class Node {
		int num;
		Node left = null;
		Node right = null;
		
		public Node(int num) {
			this.num = num;
		}
		
		static void insert(int X, Node N) {
			++C;
			if (X < N.num) {
				if (N.left == null)
					N.left = new Node(X);
				else
					insert(X, N.left);
			} else {
				if (N.right == null)
					N.right = new Node(X);
				else
					insert(X, N.right);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Node root = null;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			int X = Integer.parseInt(in.readLine());
			
			//C = 0;
			if (i == 0)
				root = new Node(X);
			else
				Node.insert(X, root);
			res.append(C + "\n");
		}
		System.out.print(res);
		
		in.close();
		System.exit(0);
	}
}
