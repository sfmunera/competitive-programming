package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1003 (10062 - Tell me the frequencies!) */
/* SUBMISSION: 11323915 */
/* SUBMISSION TIME: 2013-02-21 21:15:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10062_Tellmethefrequencies {
	
	static class Pair implements Comparable<Pair> {
		int c, f;
		public Pair(int c, int f) {
			this.c = c; this.f = f;
		}
		public int compareTo(Pair p) {
			if (this.f != p.f) return this.f - p.f;
			return p.c - this.c;
		}
		public String toString() {
			return c + " " + f;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		boolean first = true;
		while ((line = in.readLine()) != null) {
			int[] freq = new int[256];
			for (char c : line.toCharArray())
				++freq[c];
			List<Pair> pairs = new ArrayList<Pair>();
			for (int i = 0; i < 256; ++i)
				if (freq[i] > 0)
					pairs.add(new Pair(i, freq[i]));
			Collections.sort(pairs);
			
			if (first) first = false; else System.out.println();
			for (Pair p : pairs)
				System.out.println(p);
		}
		
		in.close();
		System.exit(0);
	}
	
}
