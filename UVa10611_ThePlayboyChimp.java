package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1552 (10611 - The Playboy Chimp) */
/* SUBMISSION: 10117677 */
/* SUBMISSION TIME: 2012-05-15 20:04:23 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10611_ThePlayboyChimp {
	
	static int binSearch(int[] A, int x) {
		int lo = -1;
		int hi = A.length;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] <= x)
				lo = mid + 1;
			else
				hi = mid;
		}
		return (lo == -1 || lo == A.length) ? -1 : lo;
	}

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
			
			int ind2 = binSearch(heights, q);
			
			int ind1 = ind2 - 1;
			if (ind2 < 0)
				ind1 = N - 1;
			while (ind1 >= 0 && heights[ind1] >= q)
				--ind1;
			
			System.out.println((ind1 >= 0 ? heights[ind1] : "X") + " " + (ind2 >= 0 ? heights[ind2] : "X"));
		}
		
		in.close();
		System.exit(0);
	}
}
