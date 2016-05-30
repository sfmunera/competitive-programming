package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2624 (11577 - Letter Frequency) */
/* SUBMISSION: 09132623 */
/* SUBMISSION TIME: 2011-08-10 00:53:06 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11577_LetterFrequency {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int[] freq = new int[256];
			String line = in.readLine().toLowerCase();
			for (char c : line.toCharArray())
				++freq[c];
			
			int max = 0;
			for (char c = 'a'; c <= 'z'; ++c)
				max = Math.max(max, freq[c]);
			
			String res = "";
			for (char c = 'a'; c <= 'z'; ++c)
				if (freq[c] == max)
					res += c;
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}