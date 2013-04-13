package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1833 (10892 - LCM Cardinality) */
/* SUBMISSION: 10083346 */
/* SUBMISSION TIME: 2012-05-06 23:47:45 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10892_LCMCardinality {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			ArrayList<Integer> div = new ArrayList<Integer>();
			for (int p = 1; p <= N / p; ++p) {
				if (N % p == 0) {
					div.add(p);
					if (p != N / p)
						div.add(N / p);
				}
			}
			
			Collections.sort(div);
			int cnt = 0;
			for (int i = 0; i < div.size(); ++i)
				for (int j = i; j < div.size(); ++j)
					if (lcm(div.get(j), div.get(i)) == N)
						++cnt;
			System.out.println(N + " " + cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
