import java.util.*;

/**
 *  Input:
 *	m l n
 *	m space separated words of equal length l
 *	a long word W of length n
 *	
 *	Output:
 *	The first index i such that the substring of W of length m*l starting at i is just the concatenation of all the m words in some order.
 *	
 *	Constraints:
 *	m<101
 *	l<11
 *	n<1000000
 *
 *  Solution: O(nl)
 * 
 * @author sfmunera
 *
 */

public class FindConsecutiveWords {
	private static class Pair {
		int index;
		String word;
		public Pair(int index, String word) {
			this.index = index;
			this.word = word;
		}
		
		@Override public String toString() {
			return this.index + " => " + this.word;
		}
	}

	static List<Integer> findSubstring(String W, String[] S) {
		int m = S.length;
		int l = S[0].length();
		int n = W.length();
		
		// Add the words to HashSet so that searching them takes O(1) -> O(n)
		Map<String, Integer> words = new HashMap<String, Integer>();
		for (String w : S) {
			if (!words.containsKey(w)) {
				words.put(w, 0);
			}
			words.put(w, words.get(w) + 1);
		}

		// Preprocessing: map each position in W where a word in S starts to the word itself -> O(nl)
		List<Pair> indices = new ArrayList<Pair>();
		for (int i = 0; i < n - l + 1; ++i) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < l; ++j) {
				sb.append(W.charAt(i + j));
			}
			String w = sb.toString();
			if (words.containsKey(w)) {
				indices.add(new Pair(i, w));
			}
		}
		
		List<Integer> answer = new ArrayList<Integer>();
		
		// Search for the index where the list of words appear consecutively -> O(n)
		int cnt = 0;
		Map<String, Integer> diff = new HashMap<String, Integer>();
		for (int i = 0; i < indices.size(); ++i) {
			if (cnt == m && diff.equals(words)) {
				answer.add(indices.get(i - m).index);
				cnt = 0;
				diff = new HashMap<String, Integer>();
			}
			if (i == 0 || indices.get(i).index - indices.get(i - 1).index != l) {
				diff = new HashMap<String, Integer>();
				cnt = 1;
			} else {
				++cnt;
			}
			
			String w = indices.get(i).word;
			if (!diff.containsKey(w)) {
				diff.put(w, 0);
			}
			diff.put(w, diff.get(w) + 1);
		}
		if (cnt == m && diff.equals(words)) {
			answer.add(indices.get(indices.size() - m).index);
		}

		return answer;
	}
	
	public static void main(String[] args) {
		String[] S = {"a", "a"};
		String W = "aaa";
		
		System.out.println(findSubstring(W, S));
	}
}
