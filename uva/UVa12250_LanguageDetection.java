package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3402 (12250 - Language Detection) */
/* SUBMISSION: 11411972 */
/* SUBMISSION TIME: 2013-03-09 21:23:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12250_LanguageDetection {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("HELLO", "ENGLISH");
		map.put("HOLA", "SPANISH");
		map.put("HALLO", "GERMAN");
		map.put("BONJOUR", "FRENCH");
		map.put("CIAO", "ITALIAN");
		map.put("ZDRAVSTVUJTE", "RUSSIAN");
		
		int t = 1;
		while (true) {
			String word = in.readLine();
			if (word.equals("#")) break;
			
			System.out.println("Case " + t + ": " + (map.containsKey(word) ? map.get(word) : "UNKNOWN"));
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
