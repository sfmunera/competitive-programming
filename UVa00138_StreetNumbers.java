package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 74 (138 - Street Numbers) */
/* SUBMISSION: 09153649 */
/* SUBMISSION TIME: 2011-08-15 16:54:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00138_StreetNumbers {
	public static void main(String[] args) throws IOException {
		
		int cnt = 0;
		for (long n = 2; n < 70000000 && cnt < 10; ++n) {
			long sum = n * (n + 1) / 2;
			long m = Math.round(Math.sqrt(sum));
			if (m * m == sum) {
				++cnt;
				System.out.printf("%10d%10d%n", m, n);
			}
		}
	}
}
