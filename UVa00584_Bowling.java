package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 525 (584 - Bowling) */
/* SUBMISSION: 09599000 */
/* SUBMISSION TIME: 2011-12-28 19:23:28 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00584_Bowling {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			if (line.equals("Game Over"))
				break;
			
			String[] sequence = line.split("[ ]");
			int n = sequence.length;
			char[] scores = new char[n];
			
			for (int i = 0; i < n; ++i)
				scores[i] = sequence[i].charAt(0);
			
			int score = 0;
			int frames = 0;
			for (int i = 0; i < n;) {
				int tmp = 0;
				++frames;
				if (scores[i] == 'X') {
					if (frames <= 10) {
						tmp += 10;
						if (scores[i + 2] == '/')
							tmp += 10;
						else {
							if (scores[i + 1] == 'X')
								tmp += 10;
							else
								tmp += scores[i + 1] - '0';
							
							if (scores[i + 2] == 'X')
								tmp += 10;
							else
								tmp += scores[i + 2] - '0';
						}
					}
					++i;
				} else if (Character.isDigit(scores[i])) {
					if (i + 1 < n && frames <= 10) {
						if (scores[i + 1] == '/') {
							tmp += 10;
							if (scores[i + 2] == 'X')
								tmp += 10;
							else
								tmp += scores[i + 2] - '0';
						} else
							tmp += (scores[i] - '0') + (scores[i + 1] - '0');
					}
					i += 2;
				}
				score += tmp;
			}
			System.out.println(score);
		}
		
		in.close();
		System.exit(0);
	}
}