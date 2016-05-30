package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1223 (10282 - Babelfish) */
/* SUBMISSION: 10089692 */
/* SUBMISSION TIME: 2012-05-08 15:24:12 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10282_Babelfish {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, String> dict = new HashMap<String, String>();
		String line;
		while (!(line = in.readLine()).isEmpty()) {
			String[] parts = line.split("[ ]+");
			String english = parts[0];
			String foreign = parts[1];
			dict.put(foreign, english);
		}
		while ((line = in.readLine()) != null) {
			if (dict.containsKey(line))
				System.out.println(dict.get(line));
			else
				System.out.println("eh");
		}
		
		in.close();
		System.exit(0);
	}
}
