package codeforces;

import java.util.*;

public class SuffixStructures {
	
	static boolean automaton(char[] s, char[] t) {
		if (s.length < t.length) return false;
		
		int j = 0;
		for (int i = 0; i < s.length; ++i) {
			if (j < t.length && t[j] == s[i]) {
				++j;
			}
		}
		
		return j >= t.length;
	}
	
	static boolean array(char[] s, char[] t) {
		Arrays.sort(s);
		Arrays.sort(t);
		
		return String.valueOf(s).equals(String.valueOf(t));
	}
	
	static boolean both(char[] s, char[] t) {
		array(s, t);
		return automaton(s, t);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		String t = in.next();
		
		boolean canAutomaton = automaton(s.toCharArray(), t.toCharArray());
		boolean canArray = array(s.toCharArray(), t.toCharArray());

		if (canAutomaton && !canArray) {
			System.out.println("automaton");
		} else if (canArray && !canAutomaton) {
			System.out.println("array");
		} else if (both(s.toCharArray(), t.toCharArray())) {
			System.out.println("both");
		} else {
			System.out.println("need tree");
		}
		
		in.close();
		System.exit(0);
	}
}
