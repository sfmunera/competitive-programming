package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1428 (10487 - Closest Sums) */
/* SUBMISSION: 09196350 */
/* SUBMISSION TIME: 2011-08-27 17:44:32 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10487_ClosestSums {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			int[] set = new int[N];
			for (int i = 0; i < N; ++i)
				set[i] = Integer.parseInt(in.readLine());
			
			int[] sum = new int[N * (N - 1) / 2];
			int k = 0;
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j)
					sum[k++] = set[i] + set[j];
			Arrays.sort(sum);
			System.out.println("Case " + t + ":");
			int M = Integer.parseInt(in.readLine());
			for (int i = 0; i < M; ++i) {
				int q = Integer.parseInt(in.readLine());
				int min = 0;
				int diff = Integer.MAX_VALUE;
				for (int j = 0; j < sum.length; ++j)
					if (Math.abs(q - sum[j]) < diff) {
						diff = Math.abs(q - sum[j]);
						min = sum[j];
					}
				System.out.println("Closest sum to " + q + " is " + min + ".");
			}
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
