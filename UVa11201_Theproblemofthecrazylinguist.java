package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2142 (11201 - The problem of the crazy linguist) */
/* SUBMISSION: 11333922 */
/* SUBMISSION TIME: 2013-02-24 02:59:46 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.Arrays;

public class UVa11201_Theproblemofthecrazylinguist {
	
	static final String vowels = "aeiou";
	static final String cons = "bcdfghjklmnpqrstvwxyz";
	static final double[] p = {12.53, 1.42, 4.68, 5.86, 13.68, 0.69, 1.01, 0.70, 
		                       6.25, 0.44, 0.00, 4.97, 3.15, 6.71, 8.68, 2.51, 
		                       0.88, 6.87, 7.98, 4.63, 3.93, 0.90, 0.02, 0.22, 0.90, 0.52};
	
	static String w;
	static double sum;
	static int cnt;
	static int[] reps;
	static double[][] memo;
	
	static double sbc(String w) {
		double sum = 0.0;
		for (int i = 0; i < w.length(); ++i)
			sum += (i + 1) * p[w.charAt(i) - 'a'];
		return sum;
	}
	
	static void go(String word, boolean vowel) {
		if (word.length() == w.length()) {
			sum += sbc(word);
			++cnt;
			return;
		}
		
		if (vowel) {
			for (char c : vowels.toCharArray())
				if (reps[c - 'a'] < 2) {
					++reps[c - 'a'];
					go(word + c, !vowel);
					--reps[c - 'a'];
				}
		} else {
			for (char c : cons.toCharArray())
				if (reps[c - 'a'] < 2) {
					++reps[c - 'a'];
					go(word + c, !vowel);
					--reps[c - 'a'];
				}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		memo = new double[30][10];
		
		for (int i = 0; i < 30; ++i)
			Arrays.fill(memo[i], -1);
		while (N-- > 0) {
			w = in.readLine();
			
			double score = sbc(w);
			double mean = memo[w.charAt(0) - 'a'][w.length()];
			
			if (mean == -1) {
				sum = 0.0;
				cnt = 0;
				reps = new int[26];
				go("" + w.charAt(0), true);
				memo[w.charAt(0) - 'a'][w.length()] = mean = sum / cnt;
			}
			
			if (score >= mean)
				System.out.println("above or equal");
			else
				System.out.println("below");
				
		}
		
		in.close();
		System.exit(0);
	}
}
