package leetcode;

import java.util.*;

public class LC438_FindAllAnagramsInAString {
    private Map<Character, Integer> getFrequencies(String word, int start, int end) {
		assert start >= 0 && start <= end && end < word.length();
		
		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
		for (int i = start; i <= end; i++) {
			char currentChar = word.charAt(i);
			if (!frequencies.containsKey(currentChar)) {
				frequencies.put(currentChar, 0);
			}
			int currentFrequency = frequencies.get(currentChar);
			frequencies.put(currentChar, currentFrequency + 1);
		}
		
		return frequencies;
	}
	
	private Map<Character, Integer> getFrequencies(String word) {
		return getFrequencies(word, 0, word.length() - 1);
	}
	
	private boolean areSameFrequencies(Map<Character, Integer> f1, Map<Character, Integer> f2) {
		for (char ch : f1.keySet()) {
			if (!f2.containsKey(ch)) {
				return false;
			}
		}
		
		for (char ch : f2.keySet()) {
			if (!f1.containsKey(ch)) {
				return false;
			}
		}
		
		for (char ch : f1.keySet()) {
			int count1 = f1.get(ch);
			int count2 = f2.get(ch);
			if (count1 != count2) {
				return false;
			}
		}
		
		return true;
	}
	
	private void updateFrequency(Map<Character, Integer> frequency, char toRemove, char toAdd) {
		assert frequency.containsKey(toRemove) && frequency.get(toRemove) > 0;
		
		int toRemoveFrequency = frequency.get(toRemove);
		if (toRemoveFrequency == 1) {
			frequency.remove(toRemove);
		} else {
			frequency.put(toRemove, toRemoveFrequency - 1);
		}
		
		if (!frequency.containsKey(toAdd)) {
			frequency.put(toAdd, 1);
		} else {
			int toAddFrequency = frequency.get(toAdd);
			frequency.put(toAdd, toAddFrequency + 1);
		}
	}
	
    public List<Integer> findAnagrams(String haystack, String needle) {
        List<Integer> anagramIndices = new ArrayList<Integer>();
		if (haystack == null || needle == null || haystack.isEmpty() || needle.isEmpty()) {
			return anagramIndices;
		}
		
		int haystackLength = haystack.length();
		int needleLength = needle.length();
		if (haystackLength >= needleLength) {
			Map<Character, Integer> needleFrequencies = getFrequencies(needle);
			Map<Character, Integer> runningFrequencies = getFrequencies(haystack, 0, needleLength - 1);
			if (areSameFrequencies(needleFrequencies, runningFrequencies)) {
				anagramIndices.add(0);
			}
			for (int i = needleLength; i < haystackLength; i++) {
				char toRemove = haystack.charAt(i - needleLength);
				char toAdd = haystack.charAt(i);
				updateFrequency(runningFrequencies, toRemove, toAdd);
				if (areSameFrequencies(needleFrequencies, runningFrequencies)) {
					anagramIndices.add(i - needleLength + 1);
				}
			}
		}
		
		return anagramIndices;
    }
}
