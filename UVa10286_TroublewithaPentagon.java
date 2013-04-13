package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1227 (10286 - Trouble with a Pentagon) */
/* SUBMISSION: 09302173 */
/* SUBMISSION TIME: 2011-09-26 17:46:57 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10286_TroublewithaPentagon {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			double F = Double.parseDouble(line);
			double alpha = Math.PI * 108.0 / 180.0;
			double gamma = Math.PI - alpha - (alpha - Math.PI / 2.0) / 2.0;
			double l = F * Math.sin(alpha) / Math.sin(gamma);
			System.out.printf(Locale.ENGLISH, "%.10f%n", l);
		}
		
		in.close();
		System.exit(0);
	}
}