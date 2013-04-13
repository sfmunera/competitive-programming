package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 167 (231 - Testing the CATCHER) */
/* SUBMISSION: 10165654 */
/* SUBMISSION TIME: 2012-05-28 20:43:23 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00231_TestingtheCATCHER {
	
	static int binSearch(List<Integer> A, int x) {
		if (A.isEmpty())
			return -1;
		if (A.get(A.size() - 1) < x)
			return -1;
		
		int lo = 0;
		int hi = A.size() - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (A.get(mid) <= x)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
	
	static List<Integer> lis(List<Integer> list) {
		// Compute LIS
		List<Integer> lis = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); ++i) {
			int y = list.get(i);
			int ind = binSearch(lis, y);
			if (ind == -1)
				lis.add(y);
			else
				lis.set(ind, y);
		}
		
		return lis;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		boolean first = true;
		while (true) {
			List<Integer> list = new ArrayList<Integer>();
			while (true) {
				int x = Integer.parseInt(in.readLine());
				if (x == -1)
					break;
				list.add(-x);
			}
			if (list.isEmpty())
				break;
			
			List<Integer> lis = lis(list);
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println("Test #" + t + ":");
			System.out.println("  maximum possible interceptions: " + lis.size());
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
