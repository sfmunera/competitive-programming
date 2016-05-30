package facebook;

import java.io.*;
import java.util.*;

public class Autocomplete {
	
	static TrieNode root;
	
	static class TrieNode {
		char ch;
		Map<Character, TrieNode> children;
		
		public TrieNode(char ch) {
			this.ch = ch;
			this.children = new HashMap<Character, TrieNode>();
		}
		@Override public String toString() {
			return this.ch + ", " + this.children;
		}
	}
	
	static void insertWord(String word) {
		int len = word.length();
		TrieNode node = root;
		
		for (int i = 0; i < len; ++i) {
			char ch = word.charAt(i);
			if (!node.children.containsKey(ch)) {
				node.children.put(ch, new TrieNode(ch));
			}
			node = node.children.get(ch);
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("C.in")));
		System.setOut(new PrintStream(new File("C.out")));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			root = new TrieNode('$');
			
			int ans = 0;
			for (int i = 0; i < N; ++i) {
				String word = in.readLine();
				int len = word.length();
				TrieNode node = root;
				for (int j = 0; j < len; ++j) {
					char ch = word.charAt(j);
					++ans;
					if (!node.children.containsKey(ch)) {
						break;
					}
					node = node.children.get(ch);
				}
				
				insertWord(word);
			}
			
			System.out.println("Case #" + t + ": " + ans);
		}
		
		in.close();
	}
}
