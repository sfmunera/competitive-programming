package leetcode;

public class LC008_StringToIntegerAtoi {
    
    static final String INT_MAX = "2147483647";
    static final String INT_MIN = "2147483648";
    
    boolean overflows(String str, String bound) {
        if (str.length() > bound.length()) return true;
        if (str.length() < bound.length()) return false;
        
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != bound.charAt(i)) {
                return str.charAt(i) > bound.charAt(i);
            }
        }
        
        return false;
    }
    
    public int myAtoi(String str) {
        str = str.trim();
        boolean isNegative = str.startsWith("-");
        if (str.length() > 0 && (str.charAt(0) == '+' || str.charAt(0) == '-'))
            str = str.substring(1);
        
        int ptr = 0;
        for (; ptr < str.length() && (str.charAt(ptr) >= '0' && str.charAt(ptr) <= '9'); ptr++);

        str = str.substring(0, ptr);
        if (str.length() == 0) return 0;
        if (overflows(str, isNegative ? INT_MIN : INT_MAX)) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        int num = 0;
        for (int i = 0; i < str.length(); ++i) {
            num = 10 * num + (str.charAt(i) - '0');
        }
        
        return isNegative ? -num : num;
    }
}