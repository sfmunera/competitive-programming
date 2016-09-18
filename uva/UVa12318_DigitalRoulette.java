package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3740 (12318 - Digital Roulette) */
/* SUBMISSION: 09351427 */
/* SUBMISSION TIME: 2011-10-09 14:07:32 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12318_DigitalRoulette {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("digital.in"));
		StringTokenizer stk;
		
		while (true) {
			stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());;
			
			if (N == 0 && M == 0)
				break;
			
			int k = Integer.parseInt(in.readLine());
			int[] a = new int[k + 1];
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i <= k; ++i)
				a[i] = Integer.parseInt(stk.nextToken());
			
			Set<Long> set = new HashSet<Long>();
			
			for (int x = 0; x <= M; ++x) {
				long mult = 1;
				long sum = 0;
				for (int j = 0; j <= k; ++j) {
					sum = (sum + ((mult % (N + 1)) * (a[j]  % (N + 1))) % (N + 1)) % (N + 1);
					mult = ((mult % (N + 1)) * (x % (N + 1))) % (N + 1);
				}
				set.add(sum % (N + 1));
			}
			System.out.println(set.size());
		}
		
		in.close();
		System.exit(0);
	}
}