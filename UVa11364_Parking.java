package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2349 (11364 - Parking) */
/* SUBMISSION: 09296506 */
/* SUBMISSION TIME: 2011-09-25 01:34:32 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11364_Parking {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			int[] slots = new int[N];
			for (int i = 0; i < N; ++i)
				slots[i] = Integer.parseInt(stk.nextToken());
			
			Arrays.sort(slots);
			System.out.println(2 * (slots[N - 1] - slots[0]));
		}
		
		in.close();
		System.exit(0);
	}
}
