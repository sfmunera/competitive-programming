package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Plugin {
	
	static class Node {
		char val;
		Node prev = null;
		Node next = null;
		public Node(char val) {
			this.val = val;
		}
	}
	
	static class DoublyLinkedList {
		Node head;
		public DoublyLinkedList() {
			this.head = null;
		}
		
		public void insert(char val) {
			Node node = new Node(val);
			if (head == null)
				head = node;
			else {
				head.prev = node;
				node.next = head;
				head = node;
			}
		}
		public void delete(Node node) {
			if (node.next == null && node.prev == null)
				head = null;
			else if (node.prev == null) {
				node.next.prev = null;
				head = node.next;
			} else if (node.next == null) {
				node.prev.next = null;
			} else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
		}
		public void solve() {
			Node cur = head;
			while (cur.next != null) {
				if (cur.val != cur.next.val)
					cur = cur.next;
				else {
					Node d1 = cur;
					Node d2 = cur.next;
					cur = cur.prev == null ? head : cur.prev;
					delete(d1);
					delete(d2);
				}
			}
		}
		public void print() {
			Node cur = head;
			Stack<Character> stack = new Stack<Character>();
			while (cur != null) {
				stack.push(cur.val);
				cur = cur.next;
			}
			while (!stack.isEmpty())
				System.out.print(stack.pop());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		String str = in.nextLine();
		
		DoublyLinkedList list = new DoublyLinkedList();
		for (int i = 0; i < str.length(); ++i)
			list.insert(str.charAt(i));
		list.solve();
		list.print();
		
		System.exit(0);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}
