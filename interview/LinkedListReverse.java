package interview;

public class LinkedListReverse {
	static class Node {
		Node next;
		int data;
		
		public Node(int data) {
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
				while (cur.next != null)
					cur = cur.next;
				cur.next = node;
			}
		}
		
		public void insertFirst(int x) {
			Node node = new Node(x);
			
			node.next = head;
			head = node;
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
		
		public void reverse() {
			Node cur = head;
			Node prev = null;
			
			while (cur != null) {
				Node next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			head = prev;
		}
	}
	
	public static void main(String[] args) {
		int[] val = {8, 5, 6, 10, 1, 2, 4, 7, 3, 9};
		LinkedList list = new LinkedList();
		
		for (int i = 0; i < val.length; ++i)
			list.insertLast(val[i]);
		
		list.print();
		list.reverse();
		list.print();
	}
}
