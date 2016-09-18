package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 286 (350 - Pseudo-Random Numbers) */
/* SUBMISSION: 09086697 */
/* SUBMISSION TIME: 2011-07-27 22:39:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00350_PseudoRandomNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			int Z = Integer.parseInt(stk.nextToken());
			int I = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			
			if (Z == 0 && I == 0 && M == 0 && L == 0)
				break;
			
			int len = 1;
			List<Integer> sequence = new ArrayList<Integer>();
			sequence.add(L);
			while (true) {
				L = (Z * L + I) % M;
				int ind = Collections.binarySearch(sequence, L);
				if (ind >= 0) {
					len -= ind;
					break;
				}
				sequence.add(L);
				++len;
			}
			System.out.println("Case " + t + ": " + len);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}