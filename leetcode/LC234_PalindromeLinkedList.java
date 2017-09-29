import java.util.*;

public class LC234_PalindromeLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		
		public String toString() {
			return val + (next == null ? "" : " -> " + next.toString());
		}
	}

	// Time: O(N), Space: O(N)
    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) {
        	stack.push(node.val);
        }
        for (ListNode node = head; node != null; node = node.next) {
        	if (node.val != stack.pop()) {
        		return false;
        	}
        }
        return true;
    }
    
    // Time: O(N), Space: O(1)
    public static boolean isPalindrome2(ListNode head) {
    	if (head == null || head.next == null) {
    		return true;
    	}
        int length = findLength(head);
        ListNode middle = head;
        for (int i = 0; i < length / 2 - 1; i++) {
        	middle = middle.next;
        }
        ListNode next = middle.next;
        if (length % 2 == 1) {
        	middle.next = new ListNode(next.val);
        } else {
        	middle.next = null;
        }
        ListNode reverse = reverse(next);
        if (findLength(head) != findLength(reverse)) {
        	return false;
        } else {
        	for (ListNode a = head, b = reverse; a != null && b != null; a = a.next, b = b.next) {
        		if (a.val != b.val) {
        			return false;
        		}
        	}
        }
        return true;
    }

    private static int findLength(ListNode head) {
    	int length = 0;
    	for (ListNode node = head; node != null; node = node.next) {
    		length++;
    	}
    	return length;
    }
    
    private static ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode prev = null;
    	ListNode cur = head;
    	
    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	
    	return prev;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	System.out.println(isPalindrome2(head));
    	
    	ListNode head2 = new ListNode(1);
    	head2.next = new ListNode(2);
    	head2.next.next = new ListNode(3);
    	head2.next.next.next = new ListNode(4);
    	head2.next.next.next.next = new ListNode(5);
    	System.out.println(isPalindrome2(head2));
    }
}
