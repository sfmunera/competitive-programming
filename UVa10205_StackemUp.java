package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1146 (10205 - Stack 'em Up) */
/* SUBMISSION: 09592373 */
/* SUBMISSION TIME: 2011-12-26 06:08:53 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10205_StackemUp {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		int T = in.nextInt();
		boolean first = true;
		while (T-- > 0) {
			int n = in.nextInt();
			
			int[][] shuffles = new int[n][52];
			
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < 52; ++j)
					shuffles[i][j] = in.nextInt() - 1;

			int[] deck = new int[52];
			for (int k = 0; k < 52; ++k)
				deck[k] = k;
			
			for (int i = 0; i < n; ++i) {
				int s = in.nextInt() - 1;
				int[] tmp = new int[52];
				
				for (int k = 0; k < 52; ++k)
					tmp[k] = deck[shuffles[s][k]];
				deck = tmp;
			}
			
			
			if (first)
				first = false;
			else
				System.out.println();
			for (int x : deck)
				System.out.println(ranks[x % 13] + " of " + suits[x / 13]);
		}
		
		in.close();
		System.exit(0);
	}
}