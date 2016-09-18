package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 430 (489 - Hangman Judge) */
/* SUBMISSION: 09034274 */
/* SUBMISSION TIME: 2011-07-09 22:49:40 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00489_HangmanJudge {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while (true) {
			line = in.readLine();
			int round = Integer.parseInt(line);
			if (round == -1)
				break;

			String solution = in.readLine();
			String guesses = in.readLine();
			boolean[] uncovered = new boolean[256];
			
			int strokes = 0;
			Set<Character> letters = new HashSet<Character>();
			int result = 0; // 0: chickened out, 1: win, 2: lose
			
			for (char c : solution.toCharArray())
				letters.add(c);
			int left = letters.size();
			
			for (char c : guesses.toCharArray()) {
				if (letters.contains(c)) {
					if (!uncovered[c]) {
						--left;
						uncovered[c] = true;
					}
				} else
					++strokes;
				if (strokes >= 7) {
					result = 2;
					break;
				}
				if (left <= 0) {
					result = 1;
					break;
				}
			}
			System.out.println("Round " + round);
			switch (result) {
			case 0: System.out.println("You chickened out."); break;
			case 1: System.out.println("You win."); break;
			case 2: System.out.println("You lose."); break;
			}
		}
	}
}