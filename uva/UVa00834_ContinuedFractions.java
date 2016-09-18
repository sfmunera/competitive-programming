package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 775 (834 - Continued Fractions) */
/* SUBMISSION: 09154498 */
/* SUBMISSION TIME: 2011-08-15 21:17:09 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00834_ContinuedFractions {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			
			int num = Integer.parseInt(stk.nextToken());
			int den = Integer.parseInt(stk.nextToken());
			
			List<Integer> b = new ArrayList<Integer>();
			while (den != 0) {
				int t = num / den;
				b.add(t);
				
				int tmp = num;
				num = den;
				den = tmp - t * den;
			}
			String res = "[" + b.get(0);
			for (int i = 1; i < b.size(); ++i) {
				if (i == 1)
					res += ";";
				else
					res += ",";
				res += b.get(i);
			}
			res += "]";
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}