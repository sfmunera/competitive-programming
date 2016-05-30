package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1756 (10815 - Andy's First Dictionary) */
/* SUBMISSION: 08957404 */
/* SUBMISSION TIME: 2011-06-16 14:33:15 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10815_AndysFirstDictionary {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<String> dict = new ArrayList<String>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			
			int i = 0;
			while (i < line.length()) {
				String word = "";
				while (i < line.length() && !Character.isLetter(line.charAt(i)))
					++i;
				while (i < line.length() && Character.isLetter(line.charAt(i))) {
					word += line.charAt(i);
					++i;
				}
				word = word.toLowerCase();
				if (word.isEmpty())
					continue;
				
				if (!dict.contains(word))
					dict.add(word);
				++i;
			}
		}
		Collections.sort(dict);
		for (String word : dict)
			System.out.println(word);
	}
}