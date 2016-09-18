package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 232 (296 - Safebreaker) */
/* SUBMISSION: 09958749 */
/* SUBMISSION TIME: 2012-04-05 17:19:36 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00296_Safebreaker {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int G = Integer.parseInt(in.readLine());
			char[][] guesses = new char[G][4];
			int[] guessCorrect = new int[G];
			int[] guessWrong = new int[G];
			
			for (int g = 0; g < G; ++g) {
				char[] line = in.readLine().toCharArray();
				for (int j = 0; j < 4; ++j)
					guesses[g][j] = line[j];
				guessCorrect[g] = line[5] - '0';
				guessWrong[g] = line[7] - '0';
			}
			
			int matches = 0;
			String match = "";
			for (int i = 0; i < 10000; ++i) {
				char[] code = String.format("%04d", i).toCharArray();
				boolean valid = true;
				for (int g = 0; g < G; ++g) {
					boolean[] visited1 = new boolean[4]; // Code
					boolean[] visited2 = new boolean[4]; // Guess
					
					int correct = 0;
					int wrong = 0;
					for (int j = 0; j < 4; ++j)
						if (code[j] == guesses[g][j]) {
							++correct;
							visited1[j] = true;
							visited2[j] = true;
						}
					
					for (int j = 0; j < 4; ++j)
						for (int k = 0; k < 4; ++k)
							if (j != k && !visited1[j] && !visited2[k] && 
									code[j] == guesses[g][k]) {
									++wrong;
									visited1[j] = true;
									visited2[k] = true;
							}
					if (correct != guessCorrect[g] || wrong != guessWrong[g]) {
						valid = false;
						break;
					}
				}
				
				if (valid) {
					++matches;
					match = String.valueOf(code);
				}
			}
			if (matches == 1)
				System.out.println(match);
			else if (matches == 0)
				System.out.println("impossible");
			else
				System.out.println("indeterminate");
		}
		
		in.close();
		System.exit(0);
	}
}
