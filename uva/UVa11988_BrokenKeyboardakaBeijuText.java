package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3139 (11988 - Broken Keyboard (a.k.a. Beiju Text)) */
/* SUBMISSION: 10101489 */
/* SUBMISSION TIME: 2012-05-11 15:20:56 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11988_BrokenKeyboardakaBeijuText {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			char[] stream = line.toCharArray();
			boolean begin = false;
			StringBuilder cur = new StringBuilder();
			Deque<String> total = new ArrayDeque<String>();
			
			for (char c : stream) {
				if (c == '[') {
					if (begin)
						total.offerFirst(cur.toString());
					else
						total.offerLast(cur.toString());
					cur = new StringBuilder();
					begin = true;
				} else if (c == ']') {
					if (begin)
						total.offerFirst(cur.toString());
					else
						total.offerLast(cur.toString());
					cur = new StringBuilder();
					begin = false;
				} else {
					cur.append(c);
				}
			}
			if (begin)
				total.offerFirst(cur.toString());
			else
				total.offerLast(cur.toString());
			
			StringBuilder res = new StringBuilder();
			while (!total.isEmpty())
				res.append(total.pollFirst());
			
			System.out.println(res.toString());
		}
		
		in.close();
		System.exit(0);
	}
}
