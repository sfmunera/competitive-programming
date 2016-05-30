package interview;

public class LinkedListDuplicates {

	static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.next = null;
			this.data = data;
		}
	}
	
	static class LinkedList  {
		Node head = null;
		
		void insertFirst(int x) {
			Node node = new Node(x);
			node.next = head;
			head = node;
		}
		
		void insertLast(int x) {
			Node node = new Node(x);
			
			if (head == null)
				head = node;
			else {
				Node r = head;
				while (r.next != null) {
					r = r.next;
				}
				r.next = node;
			}
		}
		
		void deleteDups() {
			Node cur = head;
			while (cur != null) {
				Node cur2 = cur;
				while (cur2.next != null)
					if (cur.data == cur2.next.data)
						cur2.next = cur2.next.next;
					else
						cur2 = cur2.next;
				cur = cur.next;
			}
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
		int[] val = {1, 4, 5, 23, 235, 65, 23, 2, 4, 5, 4, 2, 4, 6, 7, 6, 7, 7, 7, 4, 5, 5};
		
		LinkedList list = new LinkedList();
		for (int i = 0; i < val.length; ++i)
			list.insertFirst(val[i]);
		
		list.print();
		list.deleteDups();
		list.print();
	}
}
