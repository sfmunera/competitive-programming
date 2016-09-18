package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 478 (537 - Artificial Intelligence?) */
/* SUBMISSION: 09056770 */
/* SUBMISSION TIME: 2011-07-17 17:49:56 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00537_ArtificialIntelligence {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; ++t) {
			System.out.println("Problem #" + t);
			
			String line = in.readLine();
			int n = line.length();
			int k = 0;
			String concept = "PUI";
			String unit = "WVA";
			boolean[] conceptFound = new boolean[3]; // P, U, I
			double[] numbers = new double[3];
			
			int found = 0;
			
			while (k < n) {
				if (k > 0 && line.charAt(k) == '=') {
					int ind = concept.indexOf(line.charAt(k - 1));
					if (ind >= 0) {
						++k;
						String sn = "";
						while (line.charAt(k) == '.' || Character.isDigit(line.charAt(k))) {
							sn += line.charAt(k);
							++k;
						}
						double num = Double.parseDouble(sn);
						if (line.charAt(k) == 'm') {
							num /= 1000.0;
							++k;
						} else if (line.charAt(k) == 'k') {
							num *= 1000.0;
							++k;
						} else if (line.charAt(k) == 'M') {
							num *= 1000000.0;
							++k;
						}
						if (unit.charAt(ind) == line.charAt(k) && !conceptFound[ind]) {
							++found;
							numbers[ind] = num;
							conceptFound[ind] = true;
						}
					}
				}
				if (found == 2)
					break;
				++k;
			}
			
			int selected = 0;
			for (int i = 0; i < 3; ++i)
				if (!conceptFound[i]) {
					selected = i;
					break;
				}
			double res = 0.0;
			if (selected == 0)
				res = numbers[1] * numbers[2];
			if (selected == 1)
				res = numbers[0] / numbers[2];
			if (selected == 2)
				res = numbers[0] / numbers[1];
			System.out.printf(Locale.ENGLISH, "%c=%.2f%c%n", 
					concept.charAt(selected), res, unit.charAt(selected));
			
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}