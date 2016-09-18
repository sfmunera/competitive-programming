package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 528 (587 - There's treasure everywhere!) */
/* SUBMISSION: 09317310 */
/* SUBMISSION TIME: 2011-09-30 15:18:30 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00587_Therestreasureeverywhere {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			String line = in.readLine();
			
			if (line.equals("END"))
				break;
			
			String[] parts = line.substring(0, line.length() - 1).split("[,]");
			double x = 0.0;
			double y = 0.0;
			
			for (int i = 0; i < parts.length; ++i) {
				String tmp = "";
				String dir = "";
				int k = 0;
				while (k < parts[i].length() && Character.isDigit(parts[i].charAt(k))) {
					tmp += parts[i].charAt(k);
					++k;
				}
				int magnitude = Integer.parseInt(tmp);
				while (k < parts[i].length()) {
					dir += parts[i].charAt(k);
					++k;
				}
				
				if (dir.equals("N")) {
					y += magnitude;
				} else if (dir.equals("S")) {
					y -= magnitude;
				} else if (dir.equals("E")) {
					x += magnitude;
				} else if (dir.equals("W")) {
					x -= magnitude;
				} else if (dir.equals("NW")) {
					x -= magnitude / Math.sqrt(2.0);
					y += magnitude / Math.sqrt(2.0);
				} else if (dir.equals("NE")) {
					x += magnitude / Math.sqrt(2.0);
					y += magnitude / Math.sqrt(2.0);
				} else if (dir.equals("SE")) {
					x += magnitude / Math.sqrt(2.0);
					y -= magnitude / Math.sqrt(2.0);
				} else if (dir.equals("SW")) {
					x -= magnitude / Math.sqrt(2.0);
					y -= magnitude / Math.sqrt(2.0);
				}
			}
			System.out.println("Map #" + t);
			System.out.printf(Locale.ENGLISH, "The treasure is located at (%.3f,%.3f).%n", x, y);
			System.out.printf(Locale.ENGLISH, "The distance to the treasure is %.3f.%n", Math.sqrt(x * x + y * y));
			System.out.println();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}