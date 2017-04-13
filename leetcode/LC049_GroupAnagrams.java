package leetcode;

import java.util.*;

public class LC049_GroupAnagrams {
    
    private String sorted(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String sorted = sorted(str);
            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<String>());
            }
            groups.get(sorted).add(str);
        }
        List<List<String>> anagrams = new ArrayList<>();
        for (String str : groups.keySet()) {
            anagrams.add(groups.get(str));
        }
        return anagrams;
    }
}
