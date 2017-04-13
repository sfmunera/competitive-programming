package leetcode;

public class LC021_MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0); //dummy
        ListNode head = merged;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                merged.next = l2;
                break;
            } else if (l2 == null) {
                merged.next = l1;
                break;
            } else {
                ListNode current = null;
                if (l1.val < l2.val) {
                    current = l1;
                    l1 = l1.next;
                } else {
                    current = l2;
                    l2 = l2.next;
                }
                current.next = null;
                merged.next = current;
                merged = merged.next;
            }
        }
        return head.next;
    }
}