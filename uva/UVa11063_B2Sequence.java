package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2004 (11063 - B2-Sequence) */
/* SUBMISSION: 08927430 */
/* SUBMISSION TIME: 2011-06-07 19:32:53 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11063_B2Sequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (in.hasNextInt()) {
			int N = in.nextInt();
			int[] b = new int[N];
			for (int i = 0; i < N; ++i)
				b[i] = in.nextInt();
			boolean valid = true;
			
			if (b[0] < 1)
				valid = false;
			for (int i = 1; i < N && valid; ++i)
				if (b[i - 1] >= b[i])
					valid = false;
			
			if (valid) {
				int cnt = 0;
				Set<Integer> sums = new HashSet<Integer>();
				for (int i = 0; i < N; ++i)
					for (int j = i; j < N; ++j) {
						++cnt;
						sums.add(b[i] + b[j]);
					}
				if (cnt != sums.size())
					valid = false;
			}
			
			//if (t > 1)
			//	System.out.println();
			
			System.out.println("Case #" + t + ": It is " + (valid ? "" : "not ") + "a B2-Sequence.");
			System.out.println();
			++t;
		}
	}
}