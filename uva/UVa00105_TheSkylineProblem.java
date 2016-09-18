package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 41 (105 - The Skyline Problem) */
/* SUBMISSION: 09203341 */
/* SUBMISSION TIME: 2011-08-29 18:32:47 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00105_TheSkylineProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int[] height = new int[10010];
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			int L = Integer.parseInt(stk.nextToken());
			int H = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			
			for (int i = L; i < R; ++i)
				height[i] = Math.max(height[i], H);
		}
		
		String res = "";
		int cur = -1;
		for (int i = 1; i < height.length; ++i) {
			if (height[i] != cur) {
				if (i > 1)
					res += " ";
				res += i + " " + height[i];
				cur = height[i];
			}
		}
		System.out.println(res);
		
		in.close();
		System.exit(0);
	}
}
