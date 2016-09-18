package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2668 (11621 - Small Factors) */
/* SUBMISSION: 10082341 */
/* SUBMISSION TIME: 2012-05-06 17:29:31 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11621_SmallFactors {
	
	static int binSearch(List<Long> C, long m) {
		int lo = 0;
		int hi = C.size() - 1;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (C.get(mid) < m)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		List<Long> C = new ArrayList<Long>();
		long c2 = 1;
		
		
		while (c2 < (1L << 32)) {
			long c3 = 1;
			while (c2 * c3 < (1L << 32)) {
				C.add(c2 * c3);
				c3 *= 3;
			}
			c2 *= 2;
		}
		
		Collections.sort(C);
		
		while (true) {
			long m = Long.parseLong(in.readLine());
			
			if (m == 0)
				break;

			int ind = binSearch(C, m);
			System.out.println(C.get(ind));
		}
		
		in.close();
		System.exit(0);
	}
}