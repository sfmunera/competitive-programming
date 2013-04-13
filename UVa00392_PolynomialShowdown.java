package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 328 (392 - Polynomial Showdown) */
/* SUBMISSION: 10177872 */
/* SUBMISSION TIME: 2012-06-01 04:27:04 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00392_PolynomialShowdown {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			if (line.isEmpty())
				continue;
			String[] parts = line.trim().split("[ ]+");
			
			boolean first = true;
			for (int i = 0; i < parts.length; ++i) {
				int x = Integer.parseInt(parts[i]);
				if (x == 0)
					continue;
				int exp = parts.length - i - 1;
				
				if (first) {
					first = false;
					if (x < 0)
						sb.append("-");
				} else {
					if (x < 0)
						sb.append(" - ");
					else
						sb.append(" + ");
				}
				
				x = Math.abs(x);
				if (x > 1 || i == parts.length - 1)
					sb.append(x);
				if (exp > 0)
					sb.append("x");
				if (exp > 1)
					sb.append("^" + exp);
			}
			
			if (first)
				sb.append("0");
			sb.append("\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
