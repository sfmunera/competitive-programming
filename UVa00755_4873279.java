package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 696 (755 - 487--3279) */
/* SUBMISSION: 09143343 */
/* SUBMISSION TIME: 2011-08-13 01:58:59 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00755_4873279 {
	
	static class MutableInt {
		int value = 0;
		
		void inc() {
			++value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] map = new char[256];
		
		map['A'] = map['B'] = map['C'] = '2';
		map['D'] = map['E'] = map['F'] = '3';
		map['G'] = map['H'] = map['I'] = '4';
		map['J'] = map['K'] = map['L'] = '5';
		map['M'] = map['N'] = map['O'] = '6';
		map['P'] = map['R'] = map['S'] = '7';
		map['T'] = map['U'] = map['V'] = '8';
		map['W'] = map['X'] = map['Y'] = '9';
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			int N = Integer.parseInt(in.readLine());
			Map<String, MutableInt> directory = new TreeMap<String, MutableInt>();
			
			for (int i = 0; i < N; ++i) {
				String tel = in.readLine();
				StringBuilder canon = new StringBuilder();
				for (char c : tel.toCharArray())
					if (Character.isLetter(c))
						canon.append(map[c]);
					else if (Character.isDigit(c))
						canon.append(c);
				MutableInt mint = directory.get(canon.toString());
				if (mint == null) {
					mint = new MutableInt();
					directory.put(canon.toString(), mint);
				}
				mint.inc();
			}
			
			if (first)
				first = false;
			else
				System.out.println();
			
			boolean found = false;
			for (String tel : directory.keySet()) {
				int value = directory.get(tel).value;
				if (value > 1) {
					found = true;
					System.out.println(tel.substring(0, 3) + "-" + tel.substring(3) + " " + value);
					
				}
			}
			
			if (!found)
				System.out.println("No duplicates.");
		}
		
		in.close();
		System.exit(0);
	}
}
