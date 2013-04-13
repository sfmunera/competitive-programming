package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 583 (642 - Word Amalgamation) */
/* SUBMISSION: 10094114 */
/* SUBMISSION TIME: 2012-05-09 19:14:40 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00642_WordAmalgamation {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, String> dict = new HashMap<String, String>();
		String word;
		while (!(word = in.readLine()).equals("XXXXXX")) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			dict.put(word, String.valueOf(ch));
		}
		while (!(word = in.readLine()).equals("XXXXXX")) {
			Set<String> matches = new TreeSet<String>();
			for (String s : dict.keySet()) {
				char[] ch = word.toCharArray();
				Arrays.sort(ch);
				String s2 = String.valueOf(ch);
				if (s2.equals(dict.get(s)))
					matches.add(s);
			}
			
			if (!matches.isEmpty())
				for (String s : matches)
					System.out.println(s);
			else
				System.out.println("NOT A VALID WORD");
			System.out.println("******");
		}
		
		in.close();
		System.exit(0);
	}
}
