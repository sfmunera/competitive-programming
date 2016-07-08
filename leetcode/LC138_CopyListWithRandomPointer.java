package leetcode;

import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class LC138_CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if (head == null)
            return null;
            
        RandomListNode copyHead = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        map.put(head, copyHead);
        
        RandomListNode node = head;
        while (node != null) {
            RandomListNode curNode = map.get(node);
            if (node.next != null) {
                if (map.containsKey(node.next))
                    curNode.next = map.get(node.next);
                else {
                    curNode.next = new RandomListNode(node.next.label);
                    map.put(node.next, curNode.next);
                }
            }
            
            if (node.random != null) {
                if (map.containsKey(node.random))
                    curNode.random = map.get(node.random);
                else {
                    curNode.random = new RandomListNode(node.random.label);
                    map.put(node.random, curNode.random);
                }
            }
            
            node = node.next;
        }
        
        return copyHead;
    }
}
