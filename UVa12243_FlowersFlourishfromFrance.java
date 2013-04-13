package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3395 (12243 - Flowers Flourish from France) */
/* SUBMISSION: 09291228 */
/* SUBMISSION TIME: 2011-09-23 02:13:22 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12243_FlowersFlourishfromFrance {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			
			if (line.equals("*"))
				break;
			
			String[] words = line.split("[ ]");
			char initial = Character.toLowerCase(words[0].charAt(0));
			
			boolean ok = true;
			for (int i = 1; i < words.length; ++i)
				if (Character.toLowerCase(words[i].charAt(0)) != initial) {
					ok = false;
					break;
				}
			System.out.println(ok ? "Y" : "N");
		}
		
		in.close();
		System.exit(0);
	}
}
