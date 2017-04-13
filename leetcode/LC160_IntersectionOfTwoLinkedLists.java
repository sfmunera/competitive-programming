package leetcode;

public class LC160_IntersectionOfTwoLinkedLists {
    /**
     * Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                currentA = currentA.next;
                diff--;
            }
        } else if (lenA < lenB) {
            int diff = lenB - lenA;
            while (diff > 0) {
                currentB = currentB.next;
                diff--;
            }
        }
        
        ListNode intersection = null;
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                intersection = currentA;
                break;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        
        return intersection;
    }
}