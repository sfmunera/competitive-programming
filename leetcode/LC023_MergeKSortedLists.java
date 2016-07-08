package leetcode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LC023_MergeKSortedLists {

    class ListNodeComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair x, Pair y) {
            return x.l.val - y.l.val;
        }
    }
    
    class Pair {
        ListNode l;
        int index;
        public Pair(ListNode l, int index) {
            this.l = l;
            this.index = index;
        }
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = null;
        ListNode curnode = null;
        
        Comparator<Pair> comparator = new ListNodeComparator();
        
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>(10, comparator);
        
        for (int i = 0; i < lists.size(); ++i) {
            if (lists.get(i) != null) {
                Pair pair = new Pair(lists.get(i), i);
                Q.offer(pair);
                
                lists.set(i, lists.get(i).next);
            }
        }
        
        while (!Q.isEmpty()) {
            Pair p = Q.poll();
            if (head == null) {
                head = p.l;
                curnode = head;
            } else {
                curnode.next = p.l;
                curnode = curnode.next;
            }
            if (lists.get(p.index) != null) {
                Q.offer(new Pair(lists.get(p.index), p.index));
                lists.set(p.index, lists.get(p.index).next);
            }
        }
        
        return head;
    }
}
