package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1279 (10338 - Mischievous Children) */
/* SUBMISSION: 11376493 */
/* SUBMISSION TIME: 2013-03-03 22:16:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10338_MischievousChildren {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			char[] word = in.readLine().toCharArray();
			int[] freq = new int[26];
			
			for (char c : word)
				++freq[c - 'A'];
			
			int n = word.length;
			long ans = 1;
			for (int i = 1; i <= n; ++i)
				ans *= i;
			
			Arrays.sort(freq);
			for (int i = 25; i >= 0 && freq[i] > 0; --i)
				while (freq[i] > 0) {
					ans /= freq[i];
					--freq[i];
				}
			
			System.out.printf("Data set %d: %d\n", t, ans);
		}
		
		in.close();
		System.exit(0);
	}
}
