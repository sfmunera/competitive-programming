package leetcode;

import java.util.*;

public class LC020_ValidParentheses {
    private boolean isOpening(char ch) {
        return "([{".indexOf(ch) >= 0;
    }
    
    private boolean matches(char open, char close) {
        if (open == '(') return close == ')';
        else if (open == '[') return close == ']';
        else if (open == '{') return close == '}';
        else return false;
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOpening(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!matches(stack.peek(), ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
