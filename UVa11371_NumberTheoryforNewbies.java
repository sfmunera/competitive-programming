package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2366 (11371 - Number Theory for Newbies) */
/* SUBMISSION: 09174663 */
/* SUBMISSION TIME: 2011-08-20 19:49:36 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11371_NumberTheoryforNewbies {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String number;
		while ((number = in.readLine()) != null) {
			char[] c = number.toCharArray();
			Arrays.sort(c);
			String max = new StringBuffer(String.valueOf(c)).reverse().toString();
			
			int i = 0;
			while (c[i] == '0')
				++i;
			if (i < c.length) {
				char t = c[i];
				c[i] = c[0];
				c[0] = t;
			}
			String min = String.valueOf(c);
			long diff = Long.parseLong(max) - Long.parseLong(min);
			System.out.println(max + " - " + min + " = " + diff + " = 9 * " + diff / 9);
		}
		
		in.close();
		System.exit(0);
	}
}