package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1201 (10260 - Soundex) */
/* SUBMISSION: 10058530 */
/* SUBMISSION TIME: 2012-04-30 18:58:27 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10260_Soundex {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] map = new char[256];
		Arrays.fill(map, ' ');
		map['B' - 'A'] = '1';
		map['F' - 'A'] = '1';
		map['P' - 'A'] = '1';
		map['V' - 'A'] = '1';
		map['C' - 'A'] = '2';
		map['G' - 'A'] = '2';
		map['J' - 'A'] = '2';
		map['K' - 'A'] = '2';
		map['Q' - 'A'] = '2';
		map['S' - 'A'] = '2';
		map['X' - 'A'] = '2';
		map['Z' - 'A'] = '2';
		map['D' - 'A'] = '3';
		map['T' - 'A'] = '3';
		map['L' - 'A'] = '4';
		map['M' - 'A'] = '5';
		map['N' - 'A'] = '5';
		map['R' - 'A'] = '6';
		
		String line;
		while ((line = in.readLine()) != null) {
			String tmp = "" + line.charAt(0);
			for (int i = 1; i < line.length(); ++i) {
				if (map[line.charAt(i) - 'A'] != map[line.charAt(i - 1) - 'A'])
					tmp += line.charAt(i);
			}
			
			String res = "";
			for (int i = 0; i < tmp.length(); ++i) {
				if (map[tmp.charAt(i) - 'A'] != ' ')
					res += map[tmp.charAt(i) - 'A'];
			}
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
