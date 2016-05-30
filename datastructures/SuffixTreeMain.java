package datastructures;

import java.io.*;
import java.util.*;

public class SuffixTreeMain {
	public static class SuffixTree {
		Node root = new Node();
		
		public SuffixTree(String s) {
			for (int i = 0; i < s.length(); ++i) {
				String suffix = s.substring(i);
				root.insert(suffix, i);
			}
		}
		public ArrayList<Integer> search(String s) {
			return root.search(s);
		}
		public void print() {
			root.print(0);
		}
	}
	
	public static class Node {
		Node[] children = new Node[26];
		char value;
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		public Node() {};
		public Node(char c) {
			value = c;
		}

		public void insert(String s, int index) {
			indexes.add(index);
			if (s == null || s.isEmpty()) return;
			
			char first = s.charAt(0);
			if (children[first - 'a'] == null)
				children[first - 'a'] = new Node(first);
			
			String remainder = s.substring(1);
			children[first - 'a'].insert(remainder, index);
		}
		
		public ArrayList<Integer> search(String s) {
			if (s == null || s.isEmpty()) return indexes;
			
			char first = s.charAt(0);
			if (children[first - 'a'] == null) return null;
			
			String remainder = s.substring(1);
			return children[first - 'a'].search(remainder);
		}
		
		public void print(int depth) {
			for (int i = 0; i < depth; ++i)
				System.out.print(" ");
			System.out.println(value);
			
			for (int i = 0; i < children.length; ++i) {
				Node next = children[i];
				if (next != null)
					next.print(depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		String s = "thisstringisverylarge";
		
		SuffixTree tree = new SuffixTree(s);
		tree.print();
		String[] words = {"string", "very", "is", "vere", "large", "e", "t"};
		
		for (String w : words) {
			ArrayList<Integer> indexes = tree.search(w);
			if (indexes == null)
				System.out.println(w + " was not found");
			else 
				System.out.println(w + " was found at: " + indexes);
		}
		
		System.exit(0);
	}
}
