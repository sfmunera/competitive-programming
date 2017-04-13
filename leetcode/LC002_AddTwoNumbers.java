package leetcode;

public class LC002_AddTwoNumbers {
    /**
     * Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = new ListNode(0); // dummy
        ListNode sumCur = sumHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum %= 10;
            sumCur.next = new ListNode(sum);
            sumCur = sumCur.next;
        }
        if (carry > 0) {
            sumCur.next = new ListNode(carry);
        }
        
        return sumHead.next;
    }
}