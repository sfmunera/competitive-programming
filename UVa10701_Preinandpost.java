package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1642 (10701 - Pre, in and post) */
/* SUBMISSION: 11537569 */
/* SUBMISSION TIME: 2013-03-31 15:07:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10701_Preinandpost {
	
	static String inord, preord, postord;
	static int N;
	static int[] pos;
	
	static void postorder(int l, int r) {
		int i = l + 1;
		while (i <= r && pos[l] > pos[i]) ++i;
		if (l + 1 <= i - 1)
			postorder(l + 1, i - 1);
		if (i <= r)
			postorder(i, r);
		
		postord += inord.charAt(pos[l]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stk.nextToken());
			preord = stk.nextToken();
			inord = stk.nextToken();
			
			pos = new int[N];
			for (int i = 0; i < N; ++i)
				pos[i] = inord.indexOf(preord.charAt(i));
			postord = "";
			
			postorder(0, N - 1);
			System.out.println(postord);
		}
		
		in.close();
		System.exit(0);
	}
}
