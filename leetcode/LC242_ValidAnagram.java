package leetcode;

import java.util.*;

public class LC242_ValidAnagram {
    private String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    
    public boolean isAnagram(String s, String t) {
        return sorted(s).equals(sorted(t));
    }
}
