package livearchive;

import java.util.*;
import java.io.*;

class WordEquations {

	static class Node {
		String left, right;
		String text;
		Node(String left, String right, String text) {
			this.left = left;
			this.right = right;
			this.text = text;	
		}
		public String toString() {
			return left + " + " + right + " [" + text + "]";
		}
	}
	
	static StringBuilder sbTree;

	static void buildText(String str, Map<String, Node> symbolTable) {
		Node s = symbolTable.get(str);
		
		if (s.left == null && s.right == null) {
			sbTree.append(s.text);
		} else {
			buildText(s.left, symbolTable);
			buildText(s.right, symbolTable);			
		}
	}

	static boolean contains(String T, String P) {
		int lenT = T.length();
		int lenP = P.length();

		int j = 0;
		for (int i = 0; i < lenP; ++i) {
			if (j >= lenT) return false;
			while (j < lenT && P.charAt(i) != T.charAt(j)) {
				++j;
			}
			++j;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			Map<String, Node> symbolTable = new HashMap<String, Node>();
			int k = Integer.parseInt(in.readLine());
			for (int i = 0; i < k; ++i) {
				String equation = in.readLine();
				int equalPos = equation.indexOf('=');
				
				String lhs = equation.substring(0, equalPos).trim();
				String rhs = equation.substring(equalPos + 1).trim();

				if (rhs.contains("+")) {
					int plusPos = rhs.indexOf('+');
					String left = rhs.substring(0, plusPos).trim();
					String right = rhs.substring(plusPos + 1).trim();
					symbolTable.put(lhs, new Node(left, right, ""));
				} else {
					symbolTable.put(lhs, new Node(null, null, rhs));
				}
			}
			
			String start = in.readLine();
			
			sbTree = new StringBuilder();
			buildText(start, symbolTable);
			String text = sbTree.toString();

			String pattern = in.readLine();
			
			System.out.println(contains(text, pattern) ? "YES" : "NO");
	    }
	    in.close();
	}
}
