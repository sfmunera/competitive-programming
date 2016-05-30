package interview;

public class LinkedListKthToLast {
	
	static class Node {
		Node next;
		int data;
		public Node(int data) {
			this.next = null;
			this.data = data;
		}
	}
	
	static class LinkedList {
		Node head;
		
		public LinkedList() {
			this.head = null;
		}
		
		public void insertLast(int x) {
			Node node = new Node(x);
			
			if (head == null)
				head = node;
			else {
				Node cur = head;
				while (cur.next != null) {
					cur = cur.next;
				}
				cur.next = node;
			}
		}
		
		public void insertFirst(int x) {
			Node node = new Node(x);
			
			node.next = head;
			head = node;
		}
		
		public int kthToLast(int k) {
			Node second = head;
			
			for (int i = 0; i < k - 1; ++i)
				if (second == null || second.next == null)
					return -1;
				else
					second = second.next;
			
			Node first = head;
			while (second.next != null) {
				first = first.next;
				second = second.next;
			}
			return first.data;
		}
		
		void print() {
			if (head == null)
				return;
			Node cur = head;
			while (cur != null) {
				System.out.print(cur.data + " ");
				cur = cur.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		LinkedList list = new LinkedList();
		for (int i = 0; i < val.length; ++i)
			list.insertLast(val[i]);
		
		list.print();
		int kth = list.kthToLast(5);
		System.out.println(kth);
	}
}
