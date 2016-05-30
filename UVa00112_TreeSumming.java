package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 48 (112 - Tree Summing) */
/* SUBMISSION: 10879818 */
/* SUBMISSION TIME: 2012-11-13 12:53:56 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00112_TreeSumming {
	
	static int I;
	
	static String[] parseTree(String tree) {
		if (tree.equals("()"))
			return new String[]{};
		int i = 1;
		StringBuilder value = new StringBuilder();
		for (; i < tree.length(); ++i) {
			char c = tree.charAt(i);
			if (Character.isDigit(c) || c == '-')
				value.append(c);
			else break;
		}
		int cnt = 0;
		StringBuilder left = new StringBuilder();
		for (; i < tree.length(); ++i) {
			char c = tree.charAt(i);
			left.append(c);
			if (c == '(') ++cnt;
			if (c == ')') --cnt;
			if (cnt == 0) break;
		}
		++i;
		cnt = 0;
		StringBuilder right = new StringBuilder();
		for (; i < tree.length(); ++i) {
			char c = tree.charAt(i);
			right.append(c);
			if (c == '(') ++cnt;
			if (c == ')') --cnt;
			if (cnt == 0) break;
		}
		return new String[]{value.toString(), left.toString(), right.toString()};
	}
	
	static boolean treeSum(String tree, int curSum) {
		String[] parts = parseTree(tree);
		if (parts.length == 0)
			return false;
		int N = Integer.parseInt(parts[0]);
		String left = parts[1];
		String right = parts[2];
		
		if (left.equals("()") && right.equals("()") && curSum + N == I)
				return true;
		int newSum = curSum + N;
		if (treeSum(left, newSum) || treeSum(right, newSum))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			if (line.isEmpty()) continue;
			
			line = line.trim();
			String[] parts = line.split("[ ]+");
			I = Integer.parseInt(parts[0]);
			StringBuilder tmp = new StringBuilder();
			for (int i = 1; i < parts.length; ++i)
				tmp.append(parts[i]);
			
			int cnt = 0;
			for (int i = 0; i < tmp.length(); ++i) {
				char c = tmp.charAt(i);
				if (c == '(') ++cnt;
				if (c == ')') --cnt;
			}
			while (cnt != 0) {
				line = in.readLine();
				if (line.isEmpty()) continue;
				
				line = line.trim();
				for (int i = 0; i < line.length(); ++i) {
					char c = line.charAt(i);
					if (c == '(') ++cnt;
					if (c == ')') --cnt;
				}
				tmp.append(line);
			}
			StringBuilder exp = new StringBuilder();
			for (int i = 0; i < tmp.length(); ++i) {
				char c = tmp.charAt(i);
				if (c != ' ')
					exp.append(c);
			}
			
			System.out.println(treeSum(exp.toString(), 0) ? "yes" : "no");
		}
		
		in.close();
		System.exit(0);
	}
}
