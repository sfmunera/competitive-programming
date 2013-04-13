package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 437 (496 - Simply Subsets) */
/* SUBMISSION: 09977130 */
/* SUBMISSION TIME: 2012-04-10 21:47:42 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00496_SimplySubsets {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int[] A = new int[parts.length];
			
			for (int i = 0; i < parts.length; ++i)
				A[i] = Integer.parseInt(parts[i]);
			
			line = in.readLine();
			parts = line.split("[ ]+");
			int[] B = new int[parts.length];
			
			for (int i = 0; i < parts.length; ++i)
				B[i] = Integer.parseInt(parts[i]);
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int n = A.length;
			int m = B.length;
			
			int cnt = 0;
			if (m <= n) {
				for (int i = 0; i < m; ++i) {
					int ind = Arrays.binarySearch(A, B[i]);
					if (ind >= 0)
						++cnt;
				}
				
				if (cnt == 0)
					System.out.println("A and B are disjoint");
				else {
					if (cnt == m) {
						if (n == m)
							System.out.println("A equals B");
						else
							System.out.println("B is a proper subset of A");
					} else
						System.out.println("I'm confused!");
				}
			} else {
				for (int i = 0; i < n; ++i) {
					int ind = Arrays.binarySearch(B, A[i]);
					if (ind >= 0)
						++cnt;
				}
				
				if (cnt == 0)
					System.out.println("A and B are disjoint");
				else {
					if (cnt == n) {
						if (n == m)
							System.out.println("A equals B");
						else
							System.out.println("A is a proper subset of B");
					} else
						System.out.println("I'm confused!");
				}
			}
			
			
		}
		
		in.close();
		System.exit(0);
	}
}
