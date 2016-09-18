package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1381 (10440 - Ferry Loading II) */
/* SUBMISSION: 09029340 */
/* SUBMISSION TIME: 2011-07-08 14:36:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10440_FerryLoadingII {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int C = in.nextInt();
		while (C-- > 0) {
			int N = in.nextInt();
			int T = in.nextInt();
			int M = in.nextInt();
			int[] cars = new int[M];
			
			for (int i = 0; i < M; ++i)
				cars[i] = in.nextInt();
			
			int time = 0;
			int trips = 0;
			int r = M % N;
			if (r > 0) {
				time = cars[r - 1] + 2 * T;
				++trips;
			}
			for (int i = r + N - 1; i < M; i += N) {
				time = Math.max(time, cars[i]) + 2 * T;
				++trips;
			}
			time -= T;
			System.out.println(time + " " + trips);
		}
	}
}