package leetcode;

import java.util.*;
import java.io.*;

public class LC127_WordLadder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> Q = new LinkedList<String>();
        Set<String> seen = new HashSet<String>();
        Map<String, Integer> dist = new HashMap<String, Integer>();
        
        Q.offer(beginWord);
        seen.add(beginWord);
        dist.put(beginWord, 1);
        while (!Q.isEmpty()) {
            String word = Q.poll();
            if (word.equals(endWord)) {
                return dist.get(word);
            }
            
            char[] cword = word.toCharArray();
            
            for (int i = 0; i < cword.length; ++i) {
                char cur = cword[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (cur == c) continue;
                    cword[i] = c;
                    String next = String.valueOf(cword);
                    cword[i] = cur;
                    
                    if (!seen.contains(next) && wordList.contains(next)) {
                        seen.add(next);
                        dist.put(next, dist.get(word) + 1);
                        Q.offer(next);
                    } 
                }
            }
        }
        
        return 0;
    }
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("test.in"));
		Scanner in = new Scanner(System.in);
		
		String beginWord = in.next();
		String endWord = in.next();
		Set<String> wordList = new HashSet<String>();
		
		while (in.hasNext()) {
			wordList.add(in.next());
		}
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
		
		in.close();
		System.exit(0);
	}
}
