package leetcode;

public class LC345_ReverseVowelsOfAString {
	boolean isVowel(char c) {
        return "aeiouAEIOU".contains("" + c);
    }
    
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length- 1;
        
        while (left < right) {
            while (left < right && !isVowel(str[left]))
                ++left;
            while (left < right && !isVowel(str[right]))
                --right;
                
            if (left < right) {
                char t = str[left];
                str[left] = str[right];
                str[right] = t;
                ++left;
                --right;
            }
        }
        
        return String.valueOf(str);
    }
}
