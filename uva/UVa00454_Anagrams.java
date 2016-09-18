package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 395 (454 - Anagrams) */
/* SUBMISSION: 09976260 */
/* SUBMISSION TIME: 2012-04-10 15:46:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00454_Anagrams {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		boolean first = true;
		
		while (T-- > 0) {
			List<String> dict = new ArrayList<String>();
			String line;
			while ((line = in.readLine()) != null) {
				if (line.isEmpty())
					break;
				dict.add(line);
			}
			
			Collections.sort(dict);

			if (first)
				first = false;
			else
				System.out.println();
			
			for (int i = 0; i < dict.size(); ++i) {
				String[] parts = dict.get(i).split("[ ]+");
				String tmp = "";
				for (String p : parts)
					tmp += p;
				char[] str = tmp.toCharArray();
				Arrays.sort(str);
				for (int j = i + 1; j < dict.size(); ++j) {
					String[] parts2 = dict.get(j).split("[ ]+");
					String tmp2 = "";
					for (String p : parts2)
						tmp2 += p;
					char[] str2 = tmp2.toCharArray();
					Arrays.sort(str2);
					
					boolean equal = true;
					if (str.length != str2.length)
						continue;
					
					for (int k = 0; k < str.length; ++k)
						if (str[k] != str2[k]) {
							equal = false;
							break;
						}
					
					if (equal)
						System.out.println(dict.get(i) + " = " + dict.get(j));
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}
