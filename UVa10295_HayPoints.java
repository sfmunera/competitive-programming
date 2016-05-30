package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1236 (10295 - Hay Points) */
/* SUBMISSION: 10094134 */
/* SUBMISSION TIME: 2012-05-09 19:27:17 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10295_HayPoints {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]+");
		int m = Integer.parseInt(parts[0]);
		int n = Integer.parseInt(parts[1]);
		
		Map<String, Integer> value = new HashMap<String, Integer>();
		for (int i = 0; i < m; ++i) {
			parts = in.readLine().split("[ ]+");
			value.put(parts[0], Integer.parseInt(parts[1]));
		}
		
		for (int i = 0; i < n; ++i) {
			String line;
			String desc = "";
			int res = 0;
			while (!(line = in.readLine()).equals("."))
				desc += line + " ";
			desc = desc.trim();
			
			parts = desc.split("[ ]+");
			for (String s : parts)
				if (value.containsKey(s))
					res += value.get(s);
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
