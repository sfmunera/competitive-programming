package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3891 (12460 - Careful teacher) */
/* SUBMISSION: 10124631 */
/* SUBMISSION TIME: 2012-05-17 15:59:26 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12460_Carefulteacher {
	
	static Set<String> dict;
	
	static boolean bfs(String s, String t) {
		Set<String> seen = new HashSet<String>();
		Queue<String> Q = new LinkedList<String>();
		
		Q.offer(s);
		seen.add(s);
		
		while (!Q.isEmpty()) {
			String q = Q.poll();

			if (q.equals(t))
				return true;
			char[] x = q.toCharArray();
			
			for (int i = 0; i < x.length; ++i) {
				char tmp = x[i];
				for (char c = 'a'; c <= 'z'; ++c)
					if (c != tmp) {
						x[i] = c;
						String y = String.valueOf(x);
						if (dict.contains(y) && !seen.contains(y)) {
							Q.offer(y);
							seen.add(y);
						}
					}
				x[i] = tmp;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		dict = new HashSet<String>();
		String word;
		while (!(word = in.readLine()).equals("--"))
			dict.add(word);
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] words = line.split("[ ]+");
			boolean can = bfs(words[0], words[1]);
			
			System.out.println(can ? "Yes" : "No");
		}
		
		in.close();
		System.exit(0);
	}
}
