package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1640 (10699 - Count the factors) */
/* SUBMISSION: 09087186 */
/* SUBMISSION TIME: 2011-07-28 03:01:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10699_Countthefactors {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			int cnt = 0;
			int tmp = N;
			for (int p = 2; p * p <= tmp; ++p) {
				if (tmp % p == 0)
					++cnt;
				while (tmp % p == 0)
					tmp /= p;
			}
			if (N > 1)
				++cnt;
			System.out.println(N + " : " + cnt);
		}
		
		in.close();
		System.exit(0);
	}
}