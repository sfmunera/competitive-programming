package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 571 (630 - Anagrams (II)) */
/* SUBMISSION: 09976734 */
/* SUBMISSION TIME: 2012-04-10 18:48:39 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00630_AnagramsII {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(in.readLine());
		boolean first = true;
		while (M-- > 0) {
			in.readLine();
			int N = Integer.parseInt(in.readLine());
			String[] dict = new String[N];
			
			for (int i = 0; i < N; ++i)
				dict[i] = in.readLine();
			
			if (first)
				first = false;
			else
				System.out.println();
			
			String word;
			while (!(word = in.readLine()).equals("END")) {
				System.out.println("Anagrams for: " + word);
				
				int cnt = 0;
				char[] str = word.toCharArray();
				Arrays.sort(str);
				
				for (int i = 0; i < N; ++i) {
					char[] str2 = dict[i].toCharArray();
					Arrays.sort(str2);
					boolean equal = true;
					
					if (str.length != str2.length)
						equal = false;
					
					if (equal)
						for (int k = 0; k < str.length; ++k)
							if (str[k] != str2[k]) {
								equal = false;
								break;
							}
					
					if (equal) {
						++cnt;
						System.out.printf("%3d) %s\n", cnt, dict[i]);
					}
				}
				if (cnt == 0)
					System.out.println("No anagrams for: " + word);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
