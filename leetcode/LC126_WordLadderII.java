package leetcode;

import java.util.*;

public class LC126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList_) {
        Set<String> wordList = new HashSet<>(wordList_);
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> shortestDistances = findDistances(beginWord, wordList, graph);
        List<List<String>> sequences = new ArrayList<>();
        List<String> sequence = new ArrayList<>();
        findSequences(beginWord, endWord, graph, shortestDistances, sequence, sequences);
        
        return sequences;
    }
    
    private Map<String, Integer> findDistances(String beginWord, Set<String> wordList, Map<String, List<String>> graph) {
        Map<String, Integer> distance = new HashMap<>();
        Set<String> seen = new HashSet<>();
        Queue<String> Q = new LinkedList<>();
        distance.put(beginWord, 0);
        seen.add(beginWord);
        Q.add(beginWord);
        while (!Q.isEmpty()) {
            String currentWord = Q.poll();
            graph.put(currentWord, new ArrayList<String>());
            for (String word : getNeighbors(currentWord, wordList)) {
                graph.get(currentWord).add(word);
                if (!seen.contains(word)) {
                    seen.add(word);
                    distance.put(word, distance.get(currentWord) + 1);
                    Q.add(word);
                }
            }
        }
        return distance;
    }
    
    private void findSequences(String currentWord, String endWord, Map<String, List<String>> graph,
                               Map<String, Integer> shortestDistances, List<String> sequence, List<List<String>> sequences) {
        sequence.add(currentWord);
        if (currentWord.equals(endWord)) {
            sequences.add(new ArrayList<>(sequence));
        } else {
            for (String word : graph.get(currentWord)) {
                if (shortestDistances.get(word) == shortestDistances.get(currentWord) + 1) {
                    findSequences(word, endWord, graph, shortestDistances, sequence, sequences);
                }
            }
        }
        sequence.remove(sequence.size() - 1);
    }

    private Set<String> getNeighbors(String word, Set<String> wordList) {
        Set<String> neighbors = new HashSet<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (current != c) {
                    chars[i] = c;
                    String other = String.valueOf(chars);
                    if (wordList.contains(other)) {
                        neighbors.add(other);
                    }
                }
            }
            chars[i] = current;
        }
        return neighbors;
    }
}
