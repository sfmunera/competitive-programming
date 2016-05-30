
public class LinkedListGoodies {
	static class LinkedListNode {
		int val;
		LinkedListNode next;
		public LinkedListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public static LinkedListNode insert(LinkedListNode head, int val) {
		LinkedListNode node = new LinkedListNode(val);
		if (head == null) {
			head = node;
		} else {
			LinkedListNode curnode = head;
			while (curnode.next != null) {
				curnode = curnode.next;
			}
			curnode.next = node;
		}
		
		return head;
	}
	
	static void print(LinkedListNode head) {
		LinkedListNode node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	
	static LinkedListNode reverse(LinkedListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		
		LinkedListNode prev = null;
		LinkedListNode cur = head;
		while (cur.next != null) {
			LinkedListNode next = cur.next;
			cur.next = prev;
			
			prev = cur;
			cur = next;
		}
		cur.next = prev;
		
		return cur;
	}

	public static void main(String[] args) {
		//int[] A = {2, 1, 3, 0, 5};
		int[] A = {1, 2, 3, 1, 2, 3, 4};
		LinkedListNode head = null;
		
		for (int i = 0; i < A.length; ++i) {
			head = insert(head, A[i]);
		}

		print(head);
		head = reverse(head);
		print(head);
		
	}
}
