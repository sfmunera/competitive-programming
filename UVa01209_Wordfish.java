package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3650 (1209 - Wordfish) */
/* SUBMISSION: 10058832 */
/* SUBMISSION TIME: 2012-04-30 20:24:06 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01209_Wordfish {
	
	static void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(char[] c) {
		int n = c.length ;
		int k = -1;
		for (int i = n - 2; i >= 0; --i)
			if (c[i] < c[i + 1]) {
				k = i;
				break ;
			}
		if ( k == -1)
			return false ;
		int l = 0;
		for (int i = n - 1; i >= 0; --i)
			if (c[k] < c[i]) {
				l = i;
				break ;
			}
		swap(c, k, l) ;
		
		for (int i = k + 1; i < (n + k + 1) / 2; ++i)
			swap(c, i, n + k - i) ;
		
		return true;
	}
	
	static boolean prevPermutation(char[] c) {
		int n = c.length ;
		
		int i = n - 1;
		while (i > 0 && c[i - 1] <= c[i])
			--i;
		
		if (i == 0)
			return false;
		
		int k = i - 1;
		int l = 0;
		for (int j = n - 1; j >= 0; --j)
			if (c[j] < c[k]) {
				l = j;
				break;
			}
		
		swap(c, k, l) ;
		
		for (int j = k + 1; j < (n + k + 1) / 2; ++j)
			swap(c, j, n + k - j) ;
		
		return true;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String username;
		while ((username = in.readLine()) != null) {
			char[] c = username.toCharArray();
			List<String> possible = new ArrayList<String>();
			
			
			for (int i = 0; i < 10; ++i)
				if (prevPermutation(c))
					possible.add(0, String.valueOf(c));
			possible.add(username);
			
			c = username.toCharArray();
			for (int i = 0; i < 10; ++i)
				if (nextPermutation(c))
					possible.add(String.valueOf(c));
			
			String password = "";
			int largest = 0;
			for (String x : possible) {
				int min = Integer.MAX_VALUE;
				for (int i = 1; i < x.length(); ++i)
					min = Math.min(min, Math.abs(x.charAt(i) - x.charAt(i - 1)));
				if (min > largest) {
					largest = min;
					password = x;
				}
			}
			System.out.println(password + largest);
		}
		
		in.close();
		System.exit(0);
	}
}
