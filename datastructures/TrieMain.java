package datastructures;

import java.util.*;

public class TrieMain {
	static class Trie {
		private final int MAXN = 1000;
		private int[][] g = new int[MAXN][26]; // g[0] is the root ""
		private int[] words = new int[MAXN];
		private int[] prefixes = new int[MAXN];
		private int pos;
		
		public Trie() {
			Arrays.fill(g[0], -1);
			Arrays.fill(words, 0);
			Arrays.fill(prefixes, 0);
			pos = 1;
		}
		
		public void add(String word) {
			int u = 0;
			for (int k = 0; k < word.length(); ++k) {
				int next = word.charAt(k) - 'a';
				if (g[u][next] == -1) {
					g[u][next] = pos;
					Arrays.fill(g[pos], -1);
					++pos;
				}
				if (k == word.length() - 1)
					++words[u];
				else
					++prefixes[u];
				u = g[u][next];
			}
		}
	}
	
	public static void main(String[] args) {
		Trie T = new Trie();
		T.add("tree");
		T.add("trie");
		T.add("algo");
		T.add("assoc");
		T.add("all");
		T.add("also");
		
		
	}
}