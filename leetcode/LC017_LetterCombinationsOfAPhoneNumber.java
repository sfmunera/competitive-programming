package leetcode;

import java.util.*;

public class LC017_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
    	char[] current = new char[digits.length()];
    
    	generateWordsHelper(list, current, digits, 0, 0);
    
    	return list;
    }
    
    void generateWordsHelper(List<String> list, char[] current, String number, int curIndexNumber, int curIndexResult) {
    	if (curIndexNumber == number.length()) {
    		String result = new String(current, 0, curIndexNumber);
			list.add(result);
    		return;
    	}
    
    	if (number.charAt(curIndexNumber) <= '1') {
    		generateWordsHelper(list, current, number, curIndexNumber + 1, curIndexResult);
    	} else {
        	String letters = getLetters(number.charAt(curIndexNumber));
        	for (int i = 0; i < letters.length(); ++i) {
        		current[curIndexResult] = letters.charAt(i);
        		generateWordsHelper(list, current, number, curIndexNumber + 1, curIndexResult + 1);
        	}
        }
    }
    
    String getLetters(char digit) {
    	if (digit < '0' || digit > '9') {
    		return null;
    	}
    	String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    	return mapping[digit - '0'];
    }
}
