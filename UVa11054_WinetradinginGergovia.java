package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1995 (11054 - Wine trading in Gergovia) */
/* SUBMISSION: 08897676 */
/* SUBMISSION TIME: 2011-05-28 21:37:44 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11054_WinetradinginGergovia {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int N = in.nextInt();
			if (N == 0)
				break;
			
			long cost = 0;
			int[] houses = new int[N];
			for (int i = 0; i < N; ++i)
				houses[i] = in.nextInt();
			
			for (int i = 0; i < N - 1; ++i) {
				cost += Math.abs(houses[i]);
				houses[i + 1] += houses[i];
			}
			System.out.println(cost);
		}
	}
}