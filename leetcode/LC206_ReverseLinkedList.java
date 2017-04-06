package leetcode;

public class LC206_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode current = head;
            ListNode last = head.next;
            head = reverseList(head.next);
            last.next = current;
            current.next = null;
            return head;
        }
    }
}
