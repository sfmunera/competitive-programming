package bapc;

import java.util.*;

public class BAPC10I_Keylogger {
	
	static class Node {
		Node next, prev;
		char data;
		Node(char data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	static void print(Node node) {
		for (Node cur = node; cur != null; cur = cur.next) {
			System.out.print(cur.data);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			String input = in.next();
			
			Node node = new Node('$');
			Node head = node;
			for (int i = 0; i < input.length(); ++i) {
				char ch = input.charAt(i);
				if (ch == '<') {
					if (node.prev != null) node = node.prev;
				} else if (ch == '>') {
					if (node.next != null) node = node.next;
				} else if (ch == '-') {
					if (node.prev != null) {
						Node prev = node.prev;
						node.prev.next = node.next;
						if (node.next != null) {
							node.next.prev = prev;
						}
						Node tmp = node;
						node = prev;
						
						tmp.next = null;
						tmp.prev = null;
					}
				} else {
					Node newNode = new Node(ch);
					Node next = node.next;
					node.next = newNode;
					if (next != null) {
						newNode.next = next;
						next.prev = newNode;
					}
					newNode.prev = node;
					node = node.next;
				}
				
				//print(head);
			}
			
			StringBuilder sb = new StringBuilder();
			for (Node cur = head.next; cur != null; cur = cur.next) {
				sb.append(cur.data);
			}
			
			System.out.println(sb.toString());
		}
		
		in.close();
		System.exit(0);
	}
}
