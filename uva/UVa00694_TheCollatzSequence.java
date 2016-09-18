package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 635 (694 - The Collatz Sequence) */
/* SUBMISSION: 08927467 */
/* SUBMISSION TIME: 2011-06-07 19:49:18 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00694_TheCollatzSequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			long A = in.nextLong();
			long L = in.nextLong();
			if (A < 0 && L < 0)
				break;
			
			int cnt = 0;
			long At = A;
			while (true) {
				if (At > L)
					break;
				++cnt;
				if (At == 1)
					break;
				if (At % 2 == 0)
					At /= 2;
				else
					At = 3 * At + 1;
			}
			System.out.println("Case " + t + ": A = " + A + 
					", limit = " + L + ", number of terms = " + cnt);
			++t;
		}
	}
}
