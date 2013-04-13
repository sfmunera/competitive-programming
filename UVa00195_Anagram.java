package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 131 (195 - Anagram) */
/* SUBMISSION: 09145166 */
/* SUBMISSION TIME: 2011-08-13 13:04:23 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00195_Anagram {
	
	static class SortedChar implements Comparable<SortedChar> {
		char c;
		String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		
		public SortedChar(char c) {
			this.c = c;
		}

		public int compareTo(SortedChar s) {
			return alphabet.indexOf(this.c) - alphabet.indexOf(s.c);
		}
		
		public String toString() {
			return String.valueOf(this.c);
		}
	}
	
	static void swap(SortedChar[] c, int i, int j) {
		SortedChar t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(SortedChar[] w) {
		int n = w.length;
		
		int k = -1;
		for (int i = n - 2; i >= 0; --i)
			if (w[i].compareTo(w[i + 1]) < 0) {
				k = i;
				break;
			}
		if (k == -1)
			return false;
		
		int l = 0;
		for (int i = n - 1; i >= 0; --i)
			if (w[k].compareTo(w[i]) < 0) {
				l = i;
				break;
			}
		swap(w, k, l);
		for (int i = k + 1; i < (n + k + 1) / 2; ++i)
			swap(w, i, n + k - i);
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			
			int n = line.length();
			SortedChar[] word = new SortedChar[n];
			int i = 0;
			for (char c : line.toCharArray())
				word[i++] = new SortedChar(c);

			Arrays.sort(word);
			
			StringBuilder res;
			do {
				res = new StringBuilder();
				for (SortedChar c : word)
					res.append(c.c);
				System.out.println(res);
			} while (nextPermutation(word));
		}
		
		in.close();
		System.exit(0);
	}
}