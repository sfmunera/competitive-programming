package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2314 (11339 - Sonnet Rhyme Verifier) */
/* SUBMISSION: 11569165 */
/* SUBMISSION TIME: 2013-04-07 02:00:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11339_SonnetRhymeVerifier {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] allowed = {"ABBAABBACDECDE", 
							"ABBAABBACDEDCE", 
							"ABBAABBACDCDCD"};
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] suffixes = line.toLowerCase().split("[ ]+");
			String title = in.readLine();
			
			ArrayList<String> sonet = new ArrayList<String>();
			while ((line = in.readLine()) != null && !line.isEmpty()) {
				String clean = "";
				line = line.toLowerCase();
				byte[] bytes = line.getBytes();
				for (int i = 0; i < line.length(); ++i) {
					char c = line.charAt(i);
					if (c == '!' || c == ',' || c == '.' || c == ':' ||
						c == ';' || c == '?' || c == '-' || c == ' ')
						continue;
					if (bytes[i] == 168 || bytes[i] == 173) continue;
					clean += c;
				}
				if (clean.endsWith("s")) clean = clean.substring(0, clean.length() - 1);
				sonet.add(clean);
			}
			
			System.out.print(title + ": ");
			boolean ok = false;
			if (sonet.size() == 14) {
				String pattern = "";
				for (int i = 0; i < 14; ++i) {
					for (int j = 0; j < suffixes.length; ++j) {
						if (sonet.get(i).endsWith(suffixes[j])) {
							pattern += (char)(j + 'A');
							break;
						}
					}
				}
				
				for (int i = 0; i < allowed.length; ++i)
					if (pattern.equals(allowed[i])) {
						ok = true;
						System.out.println(pattern);
						break;
					}
			}
			if (!ok) System.out.println("Not a chance!");
		}
		
		in.close();
		System.exit(0);
	}
}
