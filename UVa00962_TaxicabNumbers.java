package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 903 (962 - Taxicab Numbers) */
/* SUBMISSION: 10218318 */
/* SUBMISSION TIME: 2012-06-13 03:03:13 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00962_TaxicabNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> tmp = new HashSet<Integer>();
		Set<Integer> cabs = new HashSet<Integer>();
		for (int i = 0; i <= 1001; ++i)
			for (int j = i; j <= 1001; ++j) {
				int sum = i * i * i + j * j * j;
				if (!tmp.contains(sum))
					tmp.add(sum);
				else
					cabs.add(sum);
			}
		//System.out.println(cabs.size());
		
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			int d = Integer.parseInt(in.readLine());
			
			boolean found = false;
			for (int i = N; i <= N + d; ++i) {
				if (cabs.contains(i)) {
					found = true;
					sb.append(i + "\n");
				}
			}
			
			if (!found)
				sb.append("None\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
