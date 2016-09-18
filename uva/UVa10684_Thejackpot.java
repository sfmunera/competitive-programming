package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1625 (10684 - The jackpot) */
/* SUBMISSION: 10169240 */
/* SUBMISSION TIME: 2012-05-29 22:03:11 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10684_Thejackpot {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int N = in.nextInt();
			
			if (N == 0)
				break;
			
			int[] bets = new int[N];
			for (int i = 0; i < N; ++i) {
				bets[i] = in.nextInt();
			}
			
			int max = 0;
			int c = 0;
			
			for (int i = 0; i < N; ++i) {
 				c += bets[i];
				if (c < 0)
					c = 0;
				max = Math.max(max, c);
			}
			
			if (max <= 0)
				System.out.println("Losing streak.");
			else
				System.out.println("The maximum winning streak is " + max + ".");
		}
		
		in.close();
		System.exit(0);
	}
}
