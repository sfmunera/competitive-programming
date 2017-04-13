package leetcode;

public class LC186_ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        int left = 0;
        int right = 0;
        while (left < s.length) {
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            reverse(s, left, right - 1);
            left = right + 1;
            right++;
        }
        reverse(s, 0, s.length - 1);
    }
    
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }
}
