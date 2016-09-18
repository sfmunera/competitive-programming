package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1078 (10137 - The Trip) */
/* SUBMISSION: 08996307 */
/* SUBMISSION TIME: 2011-06-28 14:14:25 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10137_TheTrip {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			
			int[] amt = new int[n];
			int mean = 0;
			for (int i = 0; i < n; ++i) {
				String[] parts = in.next().split("[.]");
				amt[i] = Integer.parseInt(parts[0]) * 100 + Integer.parseInt(parts[1]);
				mean += amt[i];
			}
			mean = Math.round((float)mean / n);
			//System.out.println(mean);
			
			int res = 0;
			int negativeDiff = 0;
			int positiveDiff = 0;
			for (int i = 0; i < n; ++i)
				if (amt[i] > mean)
					positiveDiff += amt[i] - mean;
				else
					negativeDiff += mean - amt[i];
				res = Math.min(negativeDiff, positiveDiff);
			System.out.printf(Locale.ENGLISH, "$%d.%02d%n", res / 100, res % 100);
		}
	}
}