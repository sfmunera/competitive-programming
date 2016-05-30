package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 403 (462 - Bridge Hand Evaluator) */
/* SUBMISSION: 11079982 */
/* SUBMISSION TIME: 2012-12-27 18:10:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00462_BridgeHandEvaluator {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		String suits = "SHDC";
		String ranks = "AKQJT98765432";
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			
			int[][] cards = new int[4][13]; // suits X ranks
			boolean[] stopped = new boolean[4]; // suit
			
			for (int i = 0; i < 13; ++i) {
				String card = stk.nextToken();
				char rank = card.charAt(0);
				char suit = card.charAt(1);
				++cards[suits.indexOf(suit)][ranks.indexOf(rank)];
			}
			int toSubstract = 0;
			int toAdd = 0;
			
			for (int i = 1; i < 4; ++i) { // KQJ
				for (int j = 0; j < 4; ++j) { // SHDC
					int cnt = 0;
					for (int k = 0; k < 13; ++k)
						cnt += cards[j][k];
					if (cnt - cards[j][i] <= i - 1)
						toSubstract += cards[j][i];
				}
			}
			for (int i = 0; i < 4; ++i) { // SHDC
				int cnt = 0;
				for (int j = 0; j < 13; ++j)
					cnt += cards[i][j];
				if (cnt == 2) ++toAdd;
				if (cnt == 1) toAdd += 2;
				if (cnt == 0) toAdd += 2;
			}
			for (int i = 0; i < 4; ++i) { // SHDC
				int cnt = 0;
				for (int j = 0; j < 13; ++j)
					cnt += cards[i][j];
				if (cards[i][0] > 0) stopped[i] = true;
				if (cards[i][1] > 0 && cnt - cards[i][1] > 0) stopped[i] = true;
				if (cards[i][2] > 0 && cnt - cards[i][2] > 1) stopped[i] = true;
			}
			
			int points = 0;
			for (int i = 0; i < 4; ++i) // SHDC
				for (int j = 0; j < 4; ++j) // AKQJ
					points += (4 - j) * cards[i][j];
					
			if (points - toSubstract + toAdd < 14)
				System.out.println("PASS");
			else {
				boolean ok = true;
				for (int i = 0; i < 4; ++i)
					if (!stopped[i]) ok = false;
				if (points - toSubstract >= 16 && ok)
					System.out.println("BID NO-TRUMP");
				else {
					int max = 0;
					int best = 0;
					for (int i = 0; i < 4; ++i) { // SHDC
						int cnt = 0;
						for (int j = 0; j < 13; ++j)
							cnt += cards[i][j];
						if (cnt > max) {
							max = cnt;
							best = i;
						}
					}
					System.out.println("BID " + suits.charAt(best));
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}
