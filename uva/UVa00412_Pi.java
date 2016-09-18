package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 353 (412 - Pi) */
/* SUBMISSION: 09121599 */
/* SUBMISSION TIME: 2011-08-06 20:24:10 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00412_Pi {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			int[] numbers = new int[N];
			for (int i = 0; i < N; ++i)
				numbers[i] = Integer.parseInt(in.readLine());
			
			int cnt = 0;
			int total = 0;
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j) {
					++total;
					if (gcd(numbers[i], numbers[j]) == 1)
						++cnt;
				}
			if (cnt == 0)
				System.out.println("No estimate for this data set.");
			else
				System.out.printf(Locale.ENGLISH, "%.6f%n", Math.sqrt((double)total * 6.0 / cnt));
		}
		
		in.close();
		System.exit(0);
	}
}