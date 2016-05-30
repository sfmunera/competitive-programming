package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 539 (598 - Bundling Newspapers) */
/* SUBMISSION: 11375389 */
/* SUBMISSION TIME: 2013-03-03 17:02:21 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00598_BundlingNewspapers {
	
	static ArrayList<String> words;
	
	static void go(String list, int cnt, int pos, int n, boolean first) {
		if (cnt == n) {
			System.out.println(list);
			return;
		}
		for (int j = pos + 1; j < words.size(); ++j)
			go(list + (first ? "" : ", ") + words.get(j), cnt + 1, j, n, false);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			
			words = new ArrayList<String>();
			String line;
			while ((line = in.readLine()) != null && !line.isEmpty())
				words.add(line);
			
			int a = 0, b = 0;
			if (parts[0].equals("*")) {
				a = 1;
				b = words.size();
			} else if (parts.length == 1) {
				int x = Integer.parseInt(parts[0]);
				a = b = x;
			} else {
				a = Integer.parseInt(parts[0]);
				b = Integer.parseInt(parts[1]);
			}
			
			if (first) first = false; else System.out.println();
			for (int i = a; i <= b; ++i) {
				System.out.println("Size " + i);
				go("", 0, -1, i, true);
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
