package leetcode;

import java.util.*;

public class LC232_ImplementQueueUsingStacks {
	class MyQueue {
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    // Push element x to the back of queue.
	    public void push(int x) {
	        Stack<Integer> stackTmp = new Stack<Integer>();
	        
	        while (!stack.isEmpty()) {
	            stackTmp.push(stack.pop());
	        }
	        
	        stack.push(x);
	        
	        while (!stackTmp.isEmpty()) {
	            stack.push(stackTmp.pop());
	        }
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        stack.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        return stack.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return stack.isEmpty();
	    }
	}
}
