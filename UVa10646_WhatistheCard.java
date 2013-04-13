package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1587 (10646 - What is the Card?) */
/* SUBMISSION: 09593140 */
/* SUBMISSION TIME: 2011-12-26 16:15:00 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10646_WhatistheCard {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] deck = in.readLine().split("[ ]+");
			
			int k = 52 - 25 - 1;
			int Y = 0;
			for (int j = 0; j < 3; ++j) {
				int v = Character.isDigit(deck[k].charAt(0)) ? deck[k].charAt(0) - '0' : 10;
				k -= 10 - v + 1;
				Y += v;
			}
			System.out.println("Case " + t + ": " + deck[26 + Y - k - 1]);
		}
		
		in.close();
		System.exit(0);
	}
}