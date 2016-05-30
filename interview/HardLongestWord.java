package interview;

import java.util.*;

public class HardLongestWord {
	
	static TreeSet<String> dictStr;
	static HashMap<String, Boolean> dp;
	
	static class Word implements Comparable<Word> {
		String word;
		public Word(String word) {
			this.word = word;
		}

		@Override
		public int compareTo(Word w) {
			return w.word.length() - this.word.length();
		}
		public String toString() {
			return this.word;
		}
	}
	
	static boolean checkWord(String w, int len) {
		if (w.isEmpty())
			return true;
		
		if (dp.containsKey(w))
			return dp.get(w);
		
		for (int i = 1; i <= w.length(); ++i) {
			String substring = w.substring(0, i);
			String rest = w.substring(i);
			if (substring.length() != len && dictStr.contains(substring) && checkWord(rest, len)) {
				dp.put(w, true);
				return true;
			}
		}
		
		dp.put(w, false);
		return false;
	}
	
	public static void main(String[] args) {
		TreeSet<Word> dictionary = new TreeSet<Word>();
		dictionary.add(new Word("holacomoestas"));
		dictionary.add(new Word("comoestas"));
		dictionary.add(new Word("como"));
		dictionary.add(new Word("estas"));
		dictionary.add(new Word("hola"));
		dictionary.add(new Word("holacomoestasvos"));
		dictionary.add(new Word("holaestas"));
		
		dictStr = new TreeSet<String>();
		dictStr.add("holacomoestas");
		dictStr.add("comoestas");
		dictStr.add("como");
		dictStr.add("estas");
		dictStr.add("hola");
		dictStr.add("holacomoestasvos");
		dictStr.add("holaestas");
		
		for (Word w : dictionary) {
			dp = new HashMap<String, Boolean>();
			if (checkWord(w.word, w.word.length())) {
				System.out.println(w);
				break;
			}
		}
	}
}
