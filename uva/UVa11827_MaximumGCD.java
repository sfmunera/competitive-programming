package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2927 (11827 - Maximum GCD) */
/* SUBMISSION: 09115236 */
/* SUBMISSION TIME: 2011-08-05 02:03:42 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11827_MaximumGCD {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			List<Integer> numbers = new ArrayList<Integer>();
			while (stk.hasMoreTokens())
				numbers.add(Integer.parseInt(stk.nextToken()));
			
			int n = numbers.size();
			int max = 0;
			for (int i = 0; i < n; ++i)
				for (int j = i + 1; j < n; ++j)
					max = Math.max(max, gcd(numbers.get(i), numbers.get(j)));
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}
