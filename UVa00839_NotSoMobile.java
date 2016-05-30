package uva;

import java.util.*;
import java.io.*;

public class UVa00839_NotSoMobile {
	
	static class TreeNode {
		int D, W;
		TreeNode left, right;
		public TreeNode(int W, int D, TreeNode left, TreeNode right) {
			this.W = W;
			this.D = D;
			this.left = left;
			this.right = right;
		}
		public TreeNode() {
			this.W = 0;
			this.D = 0;
			this.left = null;
			this.right = null;
		}
	}
	
	static InputReader in;
	
	static TreeNode buildTree() {
		int Wl = in.nextInt();
		int Dl = in.nextInt();
		int Wr = in.nextInt();
		int Dr = in.nextInt();
		
		TreeNode left = new TreeNode();
		TreeNode right = new TreeNode();
		if (Wl == 0)
			left = buildTree();
		if (Wr == 0)
			right = buildTree();
		left.W = Wl;
		left.D = Dl;
		right.W = Wr;
		right.D = Dr;
		
		return new TreeNode(0, 0, left, right);
	}

	static int weight(TreeNode node) {
		if (node == null)
			return 0;
				
		return node.W + weight(node.left) + weight(node.right);
	}
	
	static boolean balanced(TreeNode node) {
		if (node == null)
			return true;
		
		if (node.left == null && node.right == null)
			return true;

		return node.left.D * weight(node.left) == node.right.D * weight(node.right) && 
				balanced(node.left) && balanced(node.right);
	}

	public static void main(String[] args) throws IOException {
		in = new InputReader(System.in);
		
		boolean first = true;
		int T = in.nextInt();
		while (T-- > 0) {
			if (first)
				first = false;
			else
				System.out.println();
			
			TreeNode tree = buildTree();
			if (balanced(tree))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		System.exit(0);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}
