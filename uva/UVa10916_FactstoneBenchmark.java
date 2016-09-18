package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1857 (10916 - Factstone Benchmark) */
/* SUBMISSION: 10141919 */
/* SUBMISSION TIME: 2012-05-22 13:47:05 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10916_FactstoneBenchmark {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int year = Integer.parseInt(in.readLine());
			if (year == 0)
				break;
			
			int pow = (year - 1940) / 10;
			int word = 1 << pow;
			double logn = 0.0;
			
			int n = 1;
			while (true) {
				if (logn + Math.log(n) / Math.log(2) > word)
					break;
				logn += Math.log(n) / Math.log(2);
				++n;
			}
			
			System.out.println(n - 1);
		}
		
		in.close();
		System.exit(0);
	}
}