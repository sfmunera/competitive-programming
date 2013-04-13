package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2146 (11205 - The broken pedometer) */
/* SUBMISSION: 11038452 */
/* SUBMISSION TIME: 2012-12-16 21:04:31 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11205_Thebrokenpedometer {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int P = Integer.parseInt(in.readLine());
			int N = Integer.parseInt(in.readLine());
			
			int[] symbols = new int[N];
			
			for (int i = 0; i < N; ++i) {
				String line = in.readLine().replaceAll(" ", "");
				symbols[i] = Integer.parseInt(line, 2);
			}
			
			int ans = Integer.MAX_VALUE;
			for (int mask = 0; mask < (1 << P); ++mask) {
				Set<Integer> set = new HashSet<Integer>();
				for (int i = 0; i < N; ++i)
					set.add(mask & symbols[i]);
				if (set.size() == N)
					ans = Math.min(ans, Integer.bitCount(mask));
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
