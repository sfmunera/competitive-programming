package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2502 (11507 - Bender B. Rodríguez Problem) */
/* SUBMISSION: 09352518 */
/* SUBMISSION TIME: 2011-10-09 19:00:22 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11507_BenderBRodrguezProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int L = Integer.parseInt(in.readLine());
			if (L == 0)
				break;
			StringTokenizer stk = new StringTokenizer(in.readLine());
			
			String[][] mat = {{"+y", "-y", "+z", "-z"}, // +x
							  {"-y", "+y", "-z", "+z"}, // -x 
							  {"-x", "+x", "+y", "+y"}, // +y
							  {"+x", "-x", "-y", "-y"}, // -y
							  {"+z", "+z", "-x", "+x"}, // +z
							  {"-z", "-z", "+x", "-x"}}; // -z
			
			String s = "+x";
			for (int i = 0; i < L - 1; ++i) {
				String c = stk.nextToken();
				if (c.equals("No"))
					continue;
				int a = 0;
				if (s.equals("-x"))
					a = 1;
				if (s.equals("+y"))
					a = 2;
				if (s.equals("-y"))
					a = 3;
				if (s.equals("+z"))
					a = 4;
				if (s.equals("-z"))
					a = 5;
				
				int b = 0;
				if (c.equals("+y"))
					b = 0;
				if (c.equals("-y"))
					b = 1;
				if (c.equals("+z"))
					b = 2;
				if (c.equals("-z"))
					b = 3;
				s = mat[a][b];
			}
			System.out.println(s);
		}
		
		in.close();
		System.exit(0);
	}
}