package uva;

import java.util.*;
import java.io.*;

public class UVa10776_DetermineTheCombination {
	
	static String s;
	static int r;
	
	static void go(String cur, int seen) {
		if (cur.length() == r) {
			System.out.println(cur);
			return;
		}
		
		char last = cur.length() > 0 ? cur.charAt(cur.length() - 1) : ' ';
		for (int i = 0; i < s.length(); ++i) {
			if ((seen & (1 << i)) > 0)
				continue;
			if (s.charAt(i) >= last)
				go(cur + s.charAt(i), seen | (1 << i));
			while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
				++i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			s = stk.nextToken();
			if (s == null)
				break;
			r = Integer.parseInt(stk.nextToken());
			
			char[] c = s.toCharArray();
			Arrays.sort(c);
			s = String.valueOf(c);
			
			go("", 0);

		}
	}
}
