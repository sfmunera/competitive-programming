package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 477 (536 - Tree Recovery) */
/* SUBMISSION: 11535121 */
/* SUBMISSION TIME: 2013-03-31 06:07:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00536_TreeRecovery {
	
	static int[] list;
	static String preord;
	static String inord;
	static String postord;
	
	static void postorder(int l, int r) {
		int i = l + 1;
		while (i <= r && list[l] > list[i]) ++i;
		if (l + 1 <= i - 1)
			postorder(l + 1, i - 1);
		if (i <= r)
			postorder(i, r);
		postord += inord.charAt(list[l]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			preord = stk.nextToken();
			inord = stk.nextToken();
			
			int N = preord.length();
			list = new int[N];
			for (int i = 0; i < N; ++i)
				list[i] = inord.indexOf(preord.charAt(i));
			postord = "";
			
			postorder(0, N - 1);
			System.out.println(postord);
		}
		
		in.close();
		System.exit(0);
	}
}
