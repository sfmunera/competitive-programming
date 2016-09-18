package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1552 (10611 - The Playboy Chimp) */
/* SUBMISSION: 10117677 */
/* SUBMISSION TIME: 2012-05-15 20:04:23 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10611_ThePlayboyChimp {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] heights = new int[N];
		String[] parts = in.readLine().split("[ ]+");
		
		for (int i = 0; i < N; ++i)
			heights[i] = Integer.parseInt(parts[i]);
		
		int Q = Integer.parseInt(in.readLine());
		parts = in.readLine().split("[ ]+");
		
		for (int i = 0; i < Q; ++i) {
			int q = Integer.parseInt(parts[i]);
			int lo, hi;
			
			lo = 0;
			hi = heights.length;
			// Find position of the last element < val
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (heights[mid] >= q)
					hi = mid;
				else
					lo = mid + 1;
			}
			int ind1 = lo - 1;
			
			lo = 0;
			hi = heights.length;
			// Find position of the first element > val
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (heights[mid] > q)
					hi = mid;
				else
					lo = mid + 1;
			}
			int ind2 = lo;

			System.out.println((ind1 >= 0 ? heights[ind1] : "X") + " " + (ind2 < heights.length ? heights[ind2] : "X"));
		}
		
		in.close();
		System.exit(0);
	}
}
