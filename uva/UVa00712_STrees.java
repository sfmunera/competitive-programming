package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 653 (712 - S-Trees) */
/* SUBMISSION: 11539060 */
/* SUBMISSION TIME: 2013-04-01 01:33:41 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00712_STrees {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			int[] order = new int[N];
			StringTokenizer stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				String str = stk.nextToken();
				int o = Integer.parseInt(str.substring(1));
				order[i] = o - 1;
			}
			
			String terminal = in.readLine();
			
			int M = Integer.parseInt(in.readLine());
			String ans = "";
			for (int i = 0; i < M; ++i) {
				String vva = in.readLine();
				
				int root = 0;
				for (int j = 0; j < N; ++j)
					root = 2 * root + (vva.charAt(order[j]) - '0');
				ans += terminal.charAt(root);
			}
			System.out.println("S-Tree #" + t + ":");
			System.out.println(ans + "\n");
			
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
