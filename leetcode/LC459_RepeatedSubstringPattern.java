package leetcode;

public class LC459_RepeatedSubstringPattern {
    private boolean isRepeated(String s, int len) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i % len)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        } else if (isRepeated(s, 1)) {
            return true;
        } else {
            int length = s.length();
            for (int len = 2; len * len <= length; len++) {
                if (length % len == 0) {
                    if (isRepeated(s, len) || isRepeated(s, length / len)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
