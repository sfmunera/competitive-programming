package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1821 (10880 - Colin and Ryan) */
/* SUBMISSION: 10059905 */
/* SUBMISSION TIME: 2012-05-01 05:02:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10880_ColinandRyan {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			int C = Integer.parseInt(parts[0]);
			int R = Integer.parseInt(parts[1]);
			
			int diff = C - R;
			System.out.print("Case #" + t + ":");
			if (diff == 0)
				System.out.println(" 0");
			else {
				Set<Integer> divisors = new TreeSet<Integer>();
				for (int p = 1; p <= diff / p; ++p) {
					if (diff % p == 0) {
						if (p > R)
							divisors.add(p);
						if (diff / p > R)
							divisors.add(diff / p);
					}
				}
				for (int x : divisors)
					System.out.print(" " + x);
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}