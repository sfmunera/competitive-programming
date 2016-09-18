package leetcode;

public class LC019_RemoveNthNodeFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode ahead = head;
        for (int i = 0; i < n; ++i)
            ahead = ahead.next;
            
        ListNode cur = head;
        ListNode prev = null;
        while (ahead != null) {
            prev = cur;
            cur = cur.next;
            ahead = ahead.next;
        }
        
        if (prev == null) {
            head = cur.next;
        } else {
            prev.next = cur.next;
        }
        
        return head;
    }
}
