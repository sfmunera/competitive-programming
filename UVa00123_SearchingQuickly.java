package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 59 (123 - Searching Quickly) */
/* SUBMISSION: 10058358 */
/* SUBMISSION TIME: 2012-04-30 18:22:10 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00123_SearchingQuickly{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Set<String> ignored = new HashSet<String>();
		List<String> titles = new ArrayList<String>();
		String line;
		while (true) {
			line = in.readLine().trim();
			if (line.equals("::"))
				break;
				
			ignored.add(line.toLowerCase());
		}
		while ((line = in.readLine()) != null) {
			
			titles.add(line.trim().toLowerCase());
		}
		Set<String> noIgnored = new TreeSet<String>();
		for (String t : titles) {
			String[] parts = t.split("[ ]+");
			
			for (String s : parts)
				if (!ignored.contains(s))
					noIgnored.add(s);
		}
		
		
		
		for (String s : noIgnored) {
			for (String t : titles) {
				String[] parts = t.split("[ ]+");
				for (int i = 0; i < parts.length; ++i) {
					if (s.equals(parts[i])) {
						for (int j = 0; j < parts.length; ++j) {
							if (j > 0)
								System.out.print(" ");
							if (i != j)
								System.out.print(parts[j]);
							else
								System.out.print(parts[j].toUpperCase());
						}
						System.out.println();
					}
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}
