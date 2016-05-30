package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 98 (162 - Beggar My Neighbour) */
/* SUBMISSION: 11489259 */
/* SUBMISSION TIME: 2013-03-22 15:11:07 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00162_BeggarMyNeighbour {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String ranks = "23456789TJQKA";
		int[] values = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4};
		
		String line;
		while (!(line = in.readLine()).equals("#")) {
			String[] deck = new String[52];
			StringTokenizer stk = new StringTokenizer(line);
			
			int k = 0;
			while (stk.hasMoreTokens())
				deck[k++] = stk.nextToken();
			
			for (int i = 0; i < 3; ++i) {
				line = in.readLine();
				stk = new StringTokenizer(line);
				while (stk.hasMoreTokens())
					deck[k++] = stk.nextToken();
			}
			
			String[][] stacks = new String[3][52]; // stacks[0]: player 1, stacks[1]: player 2, stacks[2]: stack
			int[] ind = new int[3];
			for (int i = 0; i < 52; ++i)
				stacks[i % 2][ind[i % 2]++] = deck[i];

			int turn = 0;
			while (ind[turn] > 0) {
				boolean takeAll = false;
				int steps = 1;
				if (ind[2] > 0) {
					char c = stacks[2][ind[2] - 1].charAt(1);
					if (c == 'J' || c == 'Q' || c == 'K' || c == 'A') takeAll = true;
					steps = values[ranks.indexOf(c)];
				}

				boolean done = false;
				while (steps-- > 0) {
					if (ind[turn] == 0) {
						done = true;
						break;
					}
					stacks[2][ind[2]++] = stacks[turn][--ind[turn]];
					char c = stacks[2][ind[2] - 1].charAt(1);
					if (c == 'J' || c == 'Q' || c == 'K' || c == 'A') {
						takeAll = false;
						break;
					}
				}
				if (done) break;
				
				if (takeAll) {
					String[] tmp = new String[52];
					int top = 0;
					
					while (ind[2] > 0)
						tmp[top++] = stacks[2][--ind[2]];
					for (int i = 0; i < ind[1 - turn]; ++i)
						tmp[top++] = stacks[1 - turn][i];
					ind[1 - turn] = top;
					stacks[1 - turn] = tmp.clone();
				}
				turn = 1 - turn;
			}
			System.out.printf("%d%3d\n", ind[0] > 0 ? 2 : 1, ind[1 - turn]);
		}
		
		in.close();
		System.exit(0);
	}
}
