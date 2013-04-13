package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2003 (11062 - Andy's Second Dictionary) */
/* SUBMISSION: 08957287 */
/* SUBMISSION TIME: 2011-06-16 13:59:01 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11062_AndysSecondDictionary {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		List<String> dict = new ArrayList<String>();
		String tmp = "";
		while (in.hasNextLine()) {
			String line = in.nextLine();
			
			int i = 0;
			while (i < line.length()) {
				String word = "";
				while (i < line.length() && !Character.isLetter(line.charAt(i)) && line.charAt(i) != '-')
					++i;
				while (i < line.length() && (Character.isLetter(line.charAt(i)) || line.charAt(i) == '-')) {
					word += line.charAt(i);
					++i;
				}
				word = tmp + word.toLowerCase();
				if (word.isEmpty())
					continue;
				if (!tmp.isEmpty())
					tmp = "";
				if (i >= line.length()) {
					if (word.charAt(word.length() - 1) == '-')
						tmp = word.substring(0, word.length() - 1);
					else {
						if (!dict.contains(word))
							dict.add(word);
					}
				} else {
					if (!dict.contains(word))
						dict.add(word);
				}
				++i;
			}
		}
		Collections.sort(dict);
		for (String word : dict)
			System.out.println(word);
	}
}