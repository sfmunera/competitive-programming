package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1532 (10591 - Happy Number) */
/* SUBMISSION: 08927307 */
/* SUBMISSION TIME: 2011-06-07 18:27:39 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10591_HappyNumber {
	
	static boolean isHappy(int N) {
		int tmp = N;
		Set<Integer> set = new HashSet<Integer>();
		while (true) {
			set.add(tmp);
			int sum = 0;
			while (tmp > 0) {
				int d = tmp % 10;
				sum += d * d;
				tmp /= 10;
			}
			if (sum == 1)
				return true;
			if (set.contains(sum))
				return false;
			tmp = sum;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			
			System.out.println("Case #" + t + ": " + N + " is " + (isHappy(N) ? "a Happy" : "an Unhappy") + " number.");
		}
	}
}