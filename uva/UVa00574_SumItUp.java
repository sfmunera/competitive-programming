package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 515 (574 - Sum It Up) */
/* SUBMISSION: 09247049 */
/* SUBMISSION TIME: 2011-09-10 22:38:00 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00574_SumItUp {
	
	static int n, m;
	static int[] numbers;
	static List<String> res;
	
	static void backtrack(int sum, int i, String exp) {
		if (sum == n)
			if (!res.contains(exp))
				res.add(exp);
		if (sum >= n)
			return;
		
		for (int j = i + 1; j < m; ++j)
			backtrack(sum + numbers[j], j, exp + "+" + numbers[j]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			res = new ArrayList<String>();
			
			if (n == 0 && m == 0)
				break;
			
			numbers = new int[m];
			for (int i = 0; i < m; ++i)
				numbers[i] = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < m; ++i)
				backtrack(numbers[i], i, "" + numbers[i]);
			
			System.out.println("Sums of " + n + ":");
			
			if (res.isEmpty())
				System.out.println("NONE");
			else
				for (String e : res)
					System.out.println(e);
		}
		
		in.close();
		System.exit(0);
	}
}
