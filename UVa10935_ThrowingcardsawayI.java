package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1876 (10935 - Throwing cards away I) */
/* SUBMISSION: 09246710 */
/* SUBMISSION TIME: 2011-09-10 19:52:51 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10935_ThrowingcardsawayI {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		while ((N = Integer.parseInt(in.readLine())) != 0) {
			List<Integer> cards = new ArrayList<Integer>();
			List<Integer> discarded = new ArrayList<Integer>();
			for (int i = 1; i <= N; ++i)
				cards.add(i);
			while (cards.size() > 1) {
				int top = cards.get(0);
				cards.remove(0);
				discarded.add(top);
				
				top = cards.get(0);
				cards.remove(0);
				cards.add(top);
			}
			String strdiscard = discarded.toString();
			strdiscard = strdiscard.substring(1, strdiscard.length() - 1);
			System.out.println("Discarded cards:" + (strdiscard.isEmpty() ? "" : " " + strdiscard));
			System.out.println("Remaining card:" + (cards.isEmpty() ? "" : " " + cards.get(0)));
		}
		
		in.close();
		System.exit(0);
	}
}