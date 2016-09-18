package leetcode;

import java.util.*;

public class LC205_IsomorphicStrings {
    boolean maps(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isIsomorphic(String s, String t) {
        return maps(s, t) && maps(t, s);
    }
}
