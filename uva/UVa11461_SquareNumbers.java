package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2456 (11461 - Square Numbers) */
/* SUBMISSION: 08927312 */
/* SUBMISSION TIME: 2011-06-07 18:33:53 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11461_SquareNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean[] sqr = new boolean[1000000];
		for (int i = 0; i < 1000; ++i)
			sqr[i * i] = true;
		
		while (true) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a == 0 && b == 0)
				break;
			int cnt = 0;
			for (int i = a; i <= b; ++i)
				if (sqr[i])
					++cnt;
			System.out.println(cnt);
			
		}
	}
}
