package leetcode;

public class LC065_ValidNumber {
    
    boolean isInteger(String s, boolean signed) {
        if (s.startsWith("-") || s.startsWith("+")) {
            if (!signed) return false;
            s = s.substring(1);
        }
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); ++i) {
            char digit = s.charAt(i);
            if (digit < '0' || digit > '9') {
                return false;
            }
        }
        return true;
    }
    
    boolean isDecimal(String s) {
        if (s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '.') {
                if (s.length() == 1) return false;
                String prefix = s.substring(0, i);
                String suffix = s.substring(i + 1);
                return (i == 0 || isInteger(prefix, true)) && (i == s.length() - 1 || isInteger(suffix, false));
            }
        }
        
        return false;
    }
    
    boolean isScientific(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'e') {
                String prefix = s.substring(0, i);
                String suffix = s.substring(i + 1);
                return (isInteger(prefix, true) || isDecimal(prefix)) && isInteger(suffix, true);
            }
        }
        
        return false;
    }
    
    public boolean isNumber(String s) {
        s = s.trim();
        return isScientific(s) || isDecimal(s) || isInteger(s, true);
    }
}