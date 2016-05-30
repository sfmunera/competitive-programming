package eafit;

import java.io.*;

public class Majstor {
	
	static int score(char play1, char play2) {
		int score = 0;
		
		if (play1 == play2)
			score = 1;
		else if ((play1 == 'S' && play2 == 'P') ||
				 (play1 == 'P' && play2 == 'R') ||
				 (play1 == 'R' && play2 == 'S'))
			score = 2;

		return score;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int R = Integer.parseInt(in.readLine());
		char[] plays = in.readLine().toCharArray();
		int N = Integer.parseInt(in.readLine());
		String[] others = new String[N];
		int score = 0;
		int bestScore = 0;
		
		for (int i = 0; i < N; ++i)
			others[i] = in.readLine();
		
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < N; ++j)
				score += score(plays[i], others[j].charAt(i));
			
			int max = 0;
			char[] possible = {'S', 'R', 'P'};
			for (int k = 0; k < 3; ++k) {
				int tmp = 0;
				for (int j = 0; j < N; ++j)
					tmp += score(possible[k], others[j].charAt(i));
				max = Math.max(max, tmp);
			}
			bestScore += max;
		}
		System.out.println(score);
		System.out.println(bestScore);
		
		in.close();
		System.exit(0);
	}
}
