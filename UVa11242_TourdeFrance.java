package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2183 (11242 - Tour de France) */
/* SUBMISSION: 09028046 */
/* SUBMISSION TIME: 2011-07-07 23:51:47 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11242_TourdeFrance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int f = in.nextInt();
			if (f == 0)
				break;
			int r = in.nextInt();
			int[] front = new int[f];
			int[] rear = new int[r];
			
			for (int i = 0; i < f; ++i)
				front[i] = in.nextInt();
			for (int i = 0; i < r; ++i)
				rear[i] = in.nextInt();
			
			double[] d = new double[f * r];
			int k = 0;
			for (int i = 0; i < f; ++i)
				for (int j = 0; j < r; ++j)
					d[k++] = (double)rear[j] / (double)front[i];
			Arrays.sort(d);
			double max = 0.0;
			for (int i = 1; i < d.length; ++i)
				max = Math.max(max, d[i] / d[i - 1]);
			System.out.printf(Locale.ENGLISH, "%.2f%n", max);
		}
	}
}