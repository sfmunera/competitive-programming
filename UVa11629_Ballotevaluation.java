package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2676 (11629 - Ballot evaluation) */
/* SUBMISSION: 09593671 */
/* SUBMISSION TIME: 2011-12-26 19:43:17 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11629_Ballotevaluation {	
	
	static final double EPS = 1e-9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]+");
		int p = Integer.parseInt(parts[0]);
		int g = Integer.parseInt(parts[1]);
		
		Map<String, Double> map = new TreeMap<String, Double>();
		for (int i = 0; i < p; ++i) {
			parts = in.readLine().split("[ ]+");
			map.put(parts[0], Double.parseDouble(parts[1]));
		}
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= g; ++i) {
			parts = in.readLine().split("[ ]+");
			int n = parts.length;
			String op = parts[n - 2];
			double value = Double.parseDouble(parts[n - 1]);
			
			double sum = 0.0;
			for (int j = 0; j < n - 2; j += 2)
				sum += map.get(parts[j]);
			
			boolean ok = false;
			if (op.equals("<")) {
				if (sum < value - EPS)
					ok = true;
			} else if (op.equals(">")) {
				if (sum > value + EPS)
					ok = true;
			} else if (op.equals("<=")) {
				if (sum < value + EPS)
					ok = true;
			} else if (op.equals(">=")) {
				if (sum > value - EPS)
					ok = true;
			} else if (op.equals("=")) {
				if (Math.abs(sum - value) < EPS)
					ok = true;
			}
			
			sb.append("Guess #" + i + " was " + (ok ? "correct" : "incorrect") + ".\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}