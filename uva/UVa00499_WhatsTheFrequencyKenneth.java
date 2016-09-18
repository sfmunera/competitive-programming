package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 440 (499 - What's The Frequency, Kenneth?) */
/* SUBMISSION: 09105091 */
/* SUBMISSION TIME: 2011-08-01 20:32:15 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00499_WhatsTheFrequencyKenneth {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int[] map = new int[256];
			
			for (char c : line.toCharArray())
				if (Character.isLetter(c))
					++map[c];
			int max = 0;
			
			for (char c = 'A'; c <= 'z'; ++c)
				max = Math.max(max, map[c]);
			
			String letters = "";
			for (char c = 'A'; c <= 'z'; ++c)
				if (map[c] == max)
					letters += c;
			System.out.println(letters + " " + max);
		}
		
		in.close();
		System.exit(0);
	}
}