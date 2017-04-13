package leetcode;

import java.util.*;

public class LC155_MinStack {
    public class MinStack {
        private Stack<Integer> stack;
        private Map<Integer, Integer> minimum;
        private int size;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
            minimum = new HashMap<Integer, Integer>();
            size = 0;
        }
        
        public void push(int x) {
            stack.push(x);
            if (size == 0) {
                minimum.put(size + 1, x);
            } else {
                minimum.put(size + 1, Math.min(x, minimum.get(size)));
            }
            size++;
        }
        
        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minimum.remove(size);
                size--;
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minimum.get(size);
        }
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */