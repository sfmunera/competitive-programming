
public class QuicksortLinkedList {
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
	
	static LinkedListNode quicksort(LinkedListNode head) {
		if (head == null)
			return null;
		
		// Partition
		LinkedListNode leftHead = null;
		LinkedListNode leftTail = null;
		LinkedListNode rightHead = null;
		LinkedListNode rightTail = null;
		
		LinkedListNode pivot = head;
		LinkedListNode node = pivot.next;
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.val < pivot.val) {
				if (leftHead == null) {
					leftHead = node;
					leftTail = leftHead;
				} else {
					leftTail.next = node;
					leftTail = node;
				}
			} else {
				if (rightHead == null) {
					rightHead = node;
					rightTail = rightHead;
				} else {
					rightTail.next = node;
					rightTail = node;
				}
			}
			node.next = null;
			node = next;
		}
		
		// Recursive calls
		leftHead = quicksort(leftHead);
		rightHead = quicksort(rightHead);
				
		// Connect left part, pivot and right part
		pivot.next = rightHead;
		rightHead = pivot;

		if (leftHead == null) {
			head = rightHead;
		} else {
			head = leftHead;
			
			LinkedListNode cur = leftHead;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = rightHead;
		}

		return head;
	}
	
	public static void main(String[] args) {
		//int[] A = {2, 1, 3, 0, 5};
		int[] A = {1, 2, 3, 1, 2, 3, 4};
		LinkedListNode head = null;
		
		for (int i = 0; i < A.length; ++i) {
			head = insert(head, A[i]);
		}

		print(head);
		head = quicksort(head);
		print(head);
	}
}
